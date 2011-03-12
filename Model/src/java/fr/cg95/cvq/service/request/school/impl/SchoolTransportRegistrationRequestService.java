package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolTransportRegistrationRequest;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IIndividualService;

public class SchoolTransportRegistrationRequestService extends RequestService implements ISchoolTransportRegistrationRequestService {

    @Autowired
    private IRequestExternalService requestExternalService;
    @Autowired
    private IIndividualService individualService;

    @Override
    public void init() {
        SchoolTransportRegistrationRequest.conditions.put("estMaternelleElementaireAutorisations", new EqualityChecker("true"));
        SchoolTransportRegistrationRequest.conditions.put("autorisation",
                new EqualityListChecker(Arrays.asList("autoriseTiers=AvecTiers", "autoriseFrereOuSoeur=AvecFrereSoeur")));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SchoolTransportRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolTransportRegistrationRequest();
    }

    public Map<String, String> transportLines(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportLines(individualService.getChildById(childId));
        } else {
            return new HashMap<String,String>();
        }
    }

    public Map<String, String> stops(Long childId, String lineId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportStops(individualService.getChildById(childId), lineId);
        } else {
            return new HashMap<String,String>();
        }
    }
}