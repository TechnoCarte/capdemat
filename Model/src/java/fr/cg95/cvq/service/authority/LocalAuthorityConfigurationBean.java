package fr.cg95.cvq.service.authority;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.payment.IPaymentProviderService;
import fr.cg95.cvq.service.payment.PaymentServiceBean;

/**
 * A bean used to store configuration specific to a local authority.
 * 
 * This bean can be retrieved via the local authority registry.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @see ILocalAuthorityRegistry#getCurrentLocalAuthorityBean()
 */
public final class LocalAuthorityConfigurationBean {

    private static Logger logger = Logger.getLogger(LocalAuthorityConfigurationBean.class);

    private String name;
    private String defaultServerName;
    
    private SessionFactory sessionFactory;
    
    private Map<IPaymentProviderService, PaymentServiceBean> paymentServices;
    private Map<IExternalProviderService, ExternalServiceBean> externalProviderServices;
    
    private Map<String, String> ecitizenCreationNotifications;
    private Map<String, Map<String, String>> ecitizenValidationNotifications;
    private Map<String, Map<String, String>> agentNotifications;
    private Map<String, Map<String, String>> paymentNotifications;

    private boolean displayChildrenInAccountCreation = true;
    private boolean displayTutorsInAccountCreation = true;

    public LocalAuthorityConfigurationBean() {
        paymentServices =
            new HashMap<IPaymentProviderService, PaymentServiceBean>();
        externalProviderServices =
            new HashMap<IExternalProviderService, ExternalServiceBean>();
        ecitizenCreationNotifications = new HashMap<String, String>();
        ecitizenValidationNotifications =
            new HashMap<String, Map<String, String>>();
    }

    /**
     * Get the list of payment services objects for the current local authority.
     */
    public Set<IPaymentProviderService> getPaymentServicesObjects() {
        if (paymentServices == null || paymentServices.isEmpty())
            return null;

        return paymentServices.keySet();
    }
    
    /**
     * Return whether the given request type has ecitizen notification enabled for the local
     * authority associated to this bean.
     */
    public boolean hasEcitizenValidationNotification(final String requestTypeLabel) {
        if (ecitizenValidationNotifications == null)
            return false;
        
        if (ecitizenValidationNotifications.get(requestTypeLabel) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given request type
     * label.
     */
    public String getEcitizenValidationNotificationData(final String requestTypeLabel,
            final String dataKey) {
        if (ecitizenValidationNotifications == null)
            return null;
        Map<String, String> data =
            ecitizenValidationNotifications.get(requestTypeLabel);
        if (data == null)
            return null;
        return data.get(dataKey);
    }

    public Map<String, String> getEcitizenCreationNotifications() {
        return ecitizenCreationNotifications;
    }

    public void setEcitizenCreationNotifications(Map<String, String> ecitizenCreationNotifications) {
        this.ecitizenCreationNotifications = ecitizenCreationNotifications;
    }

    /**
     * Return whether the given key has agent notification enabled for the local
     * authority associated to this bean.
     */
    
    public boolean hasAgentNotification(final String agentNotificationKey) {
        if (agentNotifications== null)
            return false;
        
        if (agentNotifications.get(agentNotificationKey) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given 
     * agent's notification key
     */
    public String getAgentNotificationData(final String agentNotificationKey,
            final String dataKey) {
        if (agentNotifications== null)
            return null;
        Map<String, String> data = agentNotifications.get(agentNotificationKey);
        if (data == null)
            return null;
        return data.get(dataKey);
    }
    
    /**
     * Return whether the given key has agent notification enabled for the local
     * authority associated to this bean.
     */
    public boolean hasPaymentNotification(final String paymentNotificationKey) {
        if (paymentNotifications == null)
            return false;
        
        if (paymentNotifications.get(paymentNotificationKey) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given 
     * agent's notification key
     */
    public String getPaymentNotificationData(final String paymentNotificationKey,
            final String dataKey) {
        if (paymentNotifications == null)
            return null;
        Map<String, String> data =
            paymentNotifications.get(paymentNotificationKey);
        if (data == null)
            return null;
        return data.get(dataKey);
    }

    public void init() throws CvqConfigurationException {

        // FIXME : this should be done by the payment service
        if (paymentServices != null && paymentServices.size() > 0) {
            for (IPaymentProviderService service : paymentServices.keySet()) {
                logger.debug("init() Looking at " + service.getClass());
                service.checkConfiguration(paymentServices.get(service));
            }
        }

        // FIXME : this should be done by the external service
        if (externalProviderServices != null && externalProviderServices.size() > 0) {
            for (IExternalProviderService service : externalProviderServices.keySet()) {
                logger.debug("init() Looking at " + service.getClass());
                service.checkConfiguration(externalProviderServices.get(service), name);
            }
        }
    }
    
    /**
     * Extract email information ("Send to", "Subject", "Body") from the notifications properties
     * of the current local authority.
     * 
     * @param hasNotificationMethodName name of method that check email existence
     * @param getNotificationDataMethodName name of method that get email field
     * @param mailKey key of the email to extract
     */
    public Map<String, String> getMailAsMap(String hasNotificationMethodName, 
            String getNotificationDataMethodName, String mailKey) {
        
		try {
			Method hasNotificationMethod = 
				getClass().getDeclaredMethod(hasNotificationMethodName, 
                        new Class[] { String.class });
			Method getNotificationDataMethod = 
				getClass().getDeclaredMethod(getNotificationDataMethodName, 
                        new Class[] { String.class, String.class });
			
			if ((Boolean) hasNotificationMethod.invoke(this, new Object[] {mailKey}))  {
                Map<String, String> mailMap = new HashMap<String, String>();
                
				String mailSubject = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailSubject"});
				mailMap.put("mailSubject", mailSubject);
				String mailSendTo = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailSendTo"});
				mailMap.put("mailSendTo", mailSendTo);
				String mailData = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailData"});
				mailMap.put("mailData", mailData);
                
                return mailMap;
			}

            return null;
		} catch(Exception exception) {
			logger.error("getMailAsMap() reflection method call exception");
			exception.printStackTrace();
			return null;
		}
	}

    public boolean supportsPaymentsTab() {
        return (paymentServices != null && !paymentServices.isEmpty());
    }

    public boolean supportsActivitiesTab() {
        if (externalProviderServices == null) {
            return false;
        }
        for (IExternalProviderService s : externalProviderServices.keySet()) {
            if (s.supportsConsumptions()) {
                return true;
            }
        }
        return false;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDefaultServerName() {
        return defaultServerName;
    }

    public void setDefaultServerName(String defaultServerName) {
        this.defaultServerName = defaultServerName;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setPaymentServices(final Map<IPaymentProviderService, PaymentServiceBean> paymentServices) {
        this.paymentServices = paymentServices;
    }

    public final Map<IPaymentProviderService, PaymentServiceBean> getPaymentServices() {
        return paymentServices;
    }

    public void setExternalServices(final Map<IExternalProviderService, ExternalServiceBean> externalProviderServices) {
        this.externalProviderServices = externalProviderServices;
    }

    public Map<IExternalProviderService, ExternalServiceBean> getExternalServices() {
        return externalProviderServices;
    }
    
    public void registerExternalService(IExternalProviderService service, ExternalServiceBean esb) 
        throws CvqConfigurationException {
        
        service.checkConfiguration(esb, name);
        externalProviderServices.put(service, esb);
    }
    
    public void unregisterExternalService(IExternalProviderService service) {
        externalProviderServices.remove(service);
    }
    
    public void setEcitizenValidationNotifications(Map<String, Map<String, String>> ecitizenValidationNotifications) {
        this.ecitizenValidationNotifications = ecitizenValidationNotifications;
    }
    
	public void setAgentNotifications(Map<String, Map<String, String>> agentNotifications) {
		this.agentNotifications = agentNotifications;
	}
	
	public void setPaymentNotifications(Map<String, Map<String, String>> paymentNotifications) {
		this.paymentNotifications = paymentNotifications;
	}

    public boolean isDisplayChildrenInAccountCreation() {
        return displayChildrenInAccountCreation;
    }

    public void setDisplayChildrenInAccountCreation(boolean displayChildrenInAccountCreation) {
        this.displayChildrenInAccountCreation = displayChildrenInAccountCreation;
    }

    public boolean isDisplayTutorsInAccountCreation() {
        return displayTutorsInAccountCreation;
    }

    public void setDisplayTutorsInAccountCreation(boolean displayTutorsInAccountCreation) {
        this.displayTutorsInAccountCreation = displayTutorsInAccountCreation;
    }
}
