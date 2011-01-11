package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolTransportRegistrationRequest;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SchoolTransportRegistrationRequestService extends RequestService {

    @Override
    public void init() {
        SchoolTransportRegistrationRequest.conditions.put("autorisation",
                new EqualityListChecker(Arrays.asList("autoriseTiers=AvecTiers","autoriseFrereOuSoeur=AvecFrereSoeur")));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SchoolTransportRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolTransportRegistrationRequest();
    }
}
