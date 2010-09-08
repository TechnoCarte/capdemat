package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.ParkingSpaceReservationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class ParkingSpaceReservationRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof ParkingSpaceReservationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new ParkingSpaceReservationRequest();
    }
}
