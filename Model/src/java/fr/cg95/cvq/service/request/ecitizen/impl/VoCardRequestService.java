package fr.cg95.cvq.service.request.ecitizen.impl;

import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;


/**
 * Implementation of the account creation request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class VoCardRequestService
    extends RequestService implements IVoCardRequestService {

    static Logger logger = Logger.getLogger(VoCardRequestService.class);

    /**
     * Create an account creation request and associated objects (home folder, individuals, ...).
     *
     * Other created objects are :<br/>
     * <li>
     *  <ul>the home folder</ul>
     *  <ul>the home folder responsible</ul>
     *  <ul>the other home folder adults</ul>
     *  <ul>the home folder children</ul>
     *  <ul>the home folder address</ul>
     * </li>
     *
     */
    public void create(VoCardRequest dcvo, Set<Adult> adults, Set<Child> children, 
            final Address address) throws CvqException {

        HomeFolder homeFolder = homeFolderService.create(adults, children, address);

        dcvo.setHomeFolderId(homeFolder.getId());

        // by default, set the home folder responsible as requester        
        Adult homeFolderResponsible = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        dcvo.setRequesterId(homeFolderResponsible.getId());
        dcvo.setRequesterLastName(homeFolderResponsible.getLastName());
        
        Long requestId = super.finalizeAndPersist(dcvo);
        
        homeFolder.setOriginRequestId(requestId);
        homeFolderService.modify(homeFolder);

        logger.debug("create() Created request object with id : " + requestId);
    }

    public boolean accept(Request request) {
        return request instanceof VoCardRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new VoCardRequest();
    }
}
