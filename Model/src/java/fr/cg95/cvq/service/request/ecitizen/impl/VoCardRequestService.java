package fr.cg95.cvq.service.request.ecitizen.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
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
    @Override
    @Deprecated
    public void create(VoCardRequest dcvo, List<Adult> adults, List<Child> children, 
            final Address address) throws CvqException {

        HomeFolder homeFolder = homeFolderService.create(adults, children, address);
        dcvo.setHomeFolderId(homeFolder.getId());
        // by default, set the home folder responsible as requester
        Adult homeFolderResponsible = null;
        for (Adult adult : adults) {
            if (adult.getIndividualRoles() != null) {
                for (IndividualRole individualRole : adult.getIndividualRoles()) {
                    if (individualRole.getRole().equals(RoleType.HOME_FOLDER_RESPONSIBLE)) {
                        homeFolderResponsible = adult;
                        break;
                    }
                }
            }
        }
        SecurityContext.setCurrentEcitizen(homeFolderResponsible);
        
        dcvo.setRequesterId(homeFolderResponsible.getId());
        dcvo.setRequesterLastName(homeFolderResponsible.getLastName());
        dcvo.setRequesterFirstName(homeFolderResponsible.getFirstName());
        
        Long requestId = super.finalizeAndPersist(dcvo);
        
        homeFolder.setOriginRequestId(requestId);
        homeFolderService.modify(homeFolder);

        logger.debug("create() Created request object with id : " + requestId);
    }

    public void create(VoCardRequest dcvo, List<Adult> adults, List<Child> children, 
            List<Adult> foreignRoleOwners, final Address address, List<Document> documents) 
            throws CvqException {

        HomeFolder homeFolder = homeFolderService.create(adults, children, address);
        dcvo.setHomeFolderId(homeFolder.getId());
        // by default, set the home folder responsible as requester
        Adult homeFolderResponsible = null;
        for (Adult adult : adults) {
            if (adult.getIndividualRoles() != null) {
                for (IndividualRole individualRole : adult.getIndividualRoles()) {
                    if (individualRole.getRole().equals(RoleType.HOME_FOLDER_RESPONSIBLE)) {
                        homeFolderResponsible = adult;
                        break;
                    }
                }
            }
        }
        SecurityContext.setCurrentEcitizen(homeFolderResponsible);
        
        dcvo.setRequesterId(homeFolderResponsible.getId());
        dcvo.setRequesterLastName(homeFolderResponsible.getLastName());
        dcvo.setRequesterFirstName(homeFolderResponsible.getFirstName());
        
        Long requestId = super.finalizeAndPersist(dcvo);
        
        homeFolder.setOriginRequestId(requestId);
        homeFolderService.modify(homeFolder);
        
        addDocuments(dcvo, documents);
        
        homeFolderService.saveForeignRoleOwners(homeFolder.getId(), adults, children, 
                foreignRoleOwners);
        
        logger.debug("create() Created request object with id : " + requestId);
    }
    
    @Override
    public boolean accept(Request request) {
        return request instanceof VoCardRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new VoCardRequest();
    }
    
    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("title", new EqualityChecker("Madam"));
    }
}
