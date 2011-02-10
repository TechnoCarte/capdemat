import java.util.Hashtable

import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

class BackofficeTasksController {

    IRequestSearchService requestSearchService
    IIndividualService individualService

    def defaultAction = 'tasks'

    // Default number of tasks to show per type
    def tasksShownNb = 5
    def beforeInterceptor = {
        session['currentMenu'] = 'tasks'
    }

    def tasks = {
        def taskMap = [:]

        List<Object> lateTasks = requestSearchService.findLateTasks(tasksShownNb)
        List<Object> urgentTasks = requestSearchService.findUrgentTasks(tasksShownNb)
        List<Object> usualTasks = requestSearchService.findUsualTasks(tasksShownNb)
        taskMap.aboutRequests = [
            'late' : [
                'count' : (int) lateTasks[0],
                'all' : (List<Request>) lateTasks[1]
            ],
            'urgent' : [
                'count' : (int) urgentTasks[0],
                'all' : (List<Request>) urgentTasks[1]
            ],
            'usual' : [
                'count' : (int) usualTasks[0],
                'all' : (List<Request>) usualTasks[1]
            ]
        ]

        lateTasks = individualService.findLateTasks(tasksShownNb)
        urgentTasks = individualService.findUrgentTasks(tasksShownNb)
        usualTasks = individualService.findUsualTasks(tasksShownNb)
        taskMap.aboutIndividuals = [
            'late' : [
                'count' : (int) lateTasks[0],
                'all' : (List<Individual>) lateTasks[1]
            ],
            'urgent' : [
                'count' : (int) urgentTasks[0],
                'all' : (List<Individual>) urgentTasks[1]
            ],
            'usual' : [
                'count' : (int) usualTasks[0],
                'all' : (List<Individual>) usualTasks[1]
            ]
        ]

        return ['taskMap' : taskMap]
    }
}
