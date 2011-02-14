import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.business.users.UserAction
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

class HomeFolderAdaptorService {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    def instructionService

    public prepareAdultSubjectRoles(adult ) {
        def adultSubjectRoles = []
        homeFolderService.getBySubjectRole(adult.id, RoleType.TUTOR).each { individual ->
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
            "date" : action.date,
            "username" : instructionService.getActionPosterDetails(action.userId),
            "data" : [:]
        ]
        action.data.each {
            switch (it.key) {
                case "state" :
                    result["state"] = CapdematUtils.adaptCapdematEnum(action.data.state, "actor.state")
                    break;
                case "role" :
                    result.data.role = it.value.role
                    break;
                default :
                    result.data.(it.key) = it.value
                    break;
            }
        }
        return result
    }
}
