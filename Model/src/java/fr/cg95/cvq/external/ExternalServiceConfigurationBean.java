package fr.cg95.cvq.external;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

/**
 * A bean used to store configuration specific to the external services provided by a local authority.
 *
 * @author Florent Odier (fod@zenexity.fr)
 * @see LocalAuthorityConfigurationBean
 */
public class ExternalServiceConfigurationBean {

    private static Logger logger = Logger.getLogger(LocalAuthorityConfigurationBean.class);

    private String name;

    private Map<IExternalProviderService, ExternalServiceBean> externalProviderServices;

    public ExternalServiceConfigurationBean() {
        externalProviderServices =
            new HashMap<IExternalProviderService, ExternalServiceBean>();
    }

    public void init() throws CvqConfigurationException {
        // FIXME : this should be done by the external service
        if (externalProviderServices != null && externalProviderServices.size() > 0) {
            for (IExternalProviderService service : externalProviderServices.keySet()) {
                logger.debug("init() Looking at " + service.getClass());
                service.checkConfiguration(externalProviderServices.get(service), name);
            }
        }
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
        return name;
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

    public ExternalServiceBean getBeanForExternalService(String externalServiceLabel) {

        if (externalProviderServices != null && !externalProviderServices.isEmpty()) {
            for (IExternalProviderService service : externalProviderServices.keySet()) {
                if (service.getLabel().equals(externalServiceLabel))
                    return externalProviderServices.get(service);
            }
        }
        return null;
    }
}
