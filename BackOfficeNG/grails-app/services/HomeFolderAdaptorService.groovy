import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.business.users.UserAction
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.translation.ITranslationService

import grails.converters.JSON

class HomeFolderAdaptorService {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    ITranslationService translationService
    def instructionService

    public prepareAdultSubjectRoles(adult ) {
        def adultSubjectRoles = []
        homeFolderService.listBySubjectRole(adult.id, RoleType.TUTOR).each { individual ->
            adultSubjectRoles.add(['fullName': "${individual.firstName} ${individual.lastName}",
                'roles': individual.getIndividualRoles(adult.id)])
        }
        return adultSubjectRoles
    }

    public prepareOwnerRoles(individual) {
        def ownerRoles = ['homeFolder':[],'individual':[]]
        individual.individualRoles.each { individualRole ->
            if (individualRole.individualId) {
                def subject = individualService.getById(individualRole.individualId)
                ownerRoles.individual.add(['role':individualRole.role, 
                                           'subjectName':subject.firstName + " " + subject.lastName])
            } else {
                ownerRoles.homeFolder.add(['role':individualRole.role])                
            }
        }
        return ownerRoles
    }

    public prepareActions(actions) {
        if (!actions) actions = []
        return actions.collect { prepareAction(it) }
    }

    public prepareAction(action) {
        if (!action) return null
        def result = [
            "type" : CapdematUtils.adaptCapdematEnum(action.type, "userAction.type"),
            "date" : action.date
        ]
        if (action.data) {
            def payload = JSON.parse(action.data)
            if (payload.user.id) {
                result.username = instructionService.getActionPosterDetails(payload.user.id)
            } else {
                result.username = payload.user.name
            }
            if (payload.target.id) {
                try {
                    homeFolderService.getById(payload.target.id)
                    result.target = translationService.translate("homeFolder.header")
                } catch (CvqObjectNotFoundException) {
                    result.target = instructionService.getActionPosterDetails(payload.target.id)
                }
            } else {
                result.target = payload.target.name
            }
            if (payload.state) result.state = CapdematUtils.adaptCapdematEnum(payload.state, "actor.state")
            if (payload.responsible) {
                result.responsible = [:]
                result.responsible.types = payload.responsible.types
                result.responsible.deleted = payload.responsible.deleted
                if (payload.responsible.id)
                    result.responsible.owner = instructionService.getActionPosterDetails(payload.responsible.id)
                else
                    result.responsible.owner = payload.responsible.name
            }
        }
        return result
    }
}
