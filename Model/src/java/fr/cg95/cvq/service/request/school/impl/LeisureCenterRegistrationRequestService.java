package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.LeisureCenterRegistrationRequest;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IIndividualService;

/**
 * Implementation of the leisure center registration request service.
 * 
 * @author vsi@zenexity.com
 */
public class LeisureCenterRegistrationRequestService extends RequestService implements ILeisureCenterRegistrationRequestService {

    @Autowired
    private IRequestExternalService requestExternalService;
    @Autowired
    private IIndividualService individualService;

    @Override
    public void init() {
        LeisureCenterRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
        LeisureCenterRegistrationRequest.conditions.put("estTransport", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LeisureCenterRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LeisureCenterRegistrationRequest();
    }


    @Override
    public Map<String, String> getLeisureCenters(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getLeisureCenters(individualService.getChildById(childId));
        } else {
            return new HashMap<String,String>();
        }
    }

    @Override
    public Map<String, String> getTransportLines(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportLines(individualService.getChildById(childId));
        } else {
            return new HashMap<String,String>();
        }
    }

    @Override
    public Map<String, String> getTransportStops(Long childId, String lineId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportStops(individualService.getChildById(childId), lineId);
        } else {
            return new HashMap<String,String>();
        }
    }
}
