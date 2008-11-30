import java.util.Hashtable;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;

import grails.converters.*
import groovy.util.Expando;

class RequestController {

    IAgentService agentService
    ICategoryService categoryService
    IRequestService defaultRequestService
    IRequestStatisticsService requestStatisticsService
    IHomeFolderService homeFolderService
    
    def translationService
    
    def defaultAction = "initSearch"
    
    def supportedKeys = ["requesterLastName", "id", "homeFolderId", "creationDateFrom", "creationDateTo"]
    def longKeys = ["id", "homeFolderId"]
    def dateKeys = ["creationDateFrom", "creationDateTo"]
    def defaultSortBy = 'creationDate'
    def resultsPerPage = 15
    // default number of tasks to show per type
    def tasksShowNb = 5 
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
        
    /**
     * Called when first entering the search screen
     */
    def initSearch = {

        render(view:'search', model:['mode':'simple',
                                     'inSearch':false,
                                     'sortBy':defaultSortBy,
                                     'filters':[:]].plus(initSearchReferential()))
    }
    
    /**
     * Called asynchronously when switching from simple to advanced search mode and vice versa
     */
    def loadSearchForm = {
            def model = ['totalRecords':params.totalRecords,
                         'recordOffset':params.recordOffset,
                         'recordsReturned':params.recordsReturned,
                         'sortBy':params.sortBy,
                         'filterBy':params.filterBy].plus(initSearchReferential())

            if (params.formType == 'simple') {
                model['mode'] = 'simple'
                render(template:'simpleSearchForm', model:model)
            } else {
                model['mode'] = 'advanced'
                render(template:'advancedSearchForm', model:model)
            }
    }
    
    /**
     * Called (synchronously) when performing a search
     */
    def search = {
       
        // deal with search criteria
        Set<Critere> criteria = new HashSet<Critere>()
        params.each { key,value ->
            if (supportedKeys.contains(key) && value != "") {
                Critere critere = new Critere()
                critere.attribut = key
                critere.comparatif = Critere.EQUALS
                if (longKeys.contains(key)) {
                    critere.value = Long.valueOf(value)
                } else if (dateKeys.contains(key)) {
                    critere.value = DateUtils.stringToDate(value)
                    if (key == 'creationDateFrom') {
                        critere.attribut = 'creationDate'
                        critere.comparatif = Critere.GTE
                    } else { 
                        critere.attribut = 'creationDate'
                        critere.comparatif = Critere.LTE
                    }
                } else {
                    critere.value = value
                }
                criteria.add(critere)
            }
        }
        
        // deal with dynamic filters
        def parsedFilters = SearchUtils.parseFilters(params.filterBy)
        parsedFilters.filters.each { key, value ->
            Critere critere = new Critere()
            critere.attribut = key.replaceAll("Filter","")
            critere.comparatif = Critere.EQUALS
            if (key == 'stateFilter')
                critere.value = value
            else if (key == 'qualityFilter') {
                critere.attribut = "qualityType"
                critere.value = "qualityType"+value
            }
            else
                critere.value = Long.valueOf(value)
            criteria.add(critere)
        }
        
        // deal with dynamic sorts
        def sortBy = params.sortBy ? params.sortBy : defaultSortBy 
        log.debug "added sort on ${sortBy}"
        
        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 
            (params.recordOffset == "" || params.recordOffset == null) ? 0 : Integer.valueOf(params.recordOffset)        
            
        // now, perform the search request
        def requests = defaultRequestService.get(criteria, sortBy, params.dir, results, recordOffset)
        def recordsList = []
        requests.each {
            def agent = it.lastInterveningAgentId ? agentService.getById(it.lastInterveningAgentId) : null
            def homeFolder = homeFolderService.getById(it.homeFolderId)             
            def quality = 'green'
            if (it.redAlert)
                quality = 'red'
            else if (it.orangeAlert)
                quality = 'orange'
            def record = [
                'id':it.id,
                'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
                'creationDate':DateUtils.formatDate(it.creationDate),
                'requesterLastName':it.requesterLastName,
                'requesterFirstName': it.requesterFirstName,
                'subjectLastName':it.subjectLastName,
                'subjectFirstName': it.subjectFirstName,
                'homeFolderId':it.homeFolderId,
                'state':it.state.toString(),
                'lastModificationDate':it.lastModificationDate == null ? "" :  DateUtils.formatDate(it.lastModificationDate),
                'lastInterveningAgentId': agent ? agent.lastName + " " + agent.firstName : "",
                'permanent': !homeFolder.boundToRequest,
                'quality':quality
            ]
            recordsList.add(record)
        }
        
        render(view:'search', 
            model:['records':recordsList,
                   'recordsReturned':requests.size(),
                   'totalRecords':defaultRequestService.getCount(criteria),
                   'filters':parsedFilters.filters,
                   'filterBy':parsedFilters.filterBy,
                   'mode':params.mode,
                   'recordOffset':recordOffset,
                   'sortBy':sortBy,
                   'dir':params.dir,
                   'inSearch':true].plus(initSearchReferential()))
    }

    /**
     * Called when asking for the agent's task board
     */
    def taskBoard = {
        def state = [:]
        def pageState = ""
        def method = request.getMethod().toLowerCase()
        Agent agent = SecurityContext.getCurrentAgent()
        
        state['displayForm'] = agentService.getPreferenceByKey(agent,'display')?.displayForm?.split(",") as List
        if(state['displayForm'] == null)
            state['displayForm'] = ['Late','Alert','New','Last','Validated']
        
        if(method == 'get') {
            state['defaultDisplay'] = state['displayForm']
            state['filters'] = ['categoryFilter':'','requestTypeIdFilter':'']
        } else { 
            state = JSON.parse(params.pageState);
        }
        
        if(state.modifyDisplay == true) {
            Hashtable<String, String> hash = new Hashtable<String, String>()
            hash.put('displayForm', state.displayForm?.join(",").replace('\"',''))
            agentService.modifyPreference(agent,'display',hash)
            state.modifyDisplay = null
            state['defaultDisplay'] = state['displayForm']
            state['message'] = message(code:"message.updateDone")
        }
        
        pageState = (new JSON(state)).toString()
        session["currentMenu"] = "taskBoard"
        
        def requestMap = [:]
        
        if(state?.displayForm?.contains('Late'))
            requestMap.redRequests = filterRequests("SEARCH_BY_QUALITY_TYPE",Request.QUALITY_TYPE_RED,state)
        if(state?.displayForm?.contains('Alert'))
            requestMap.orangeRequests = filterRequests("SEARCH_BY_QUALITY_TYPE",Request.QUALITY_TYPE_ORANGE,state)
        if(state?.displayForm?.contains('New'))
            requestMap.pendingRequests = filterRequests("SEARCH_BY_STATE",RequestState.PENDING,state)
        if(state?.displayForm?.contains('Validated'))
            requestMap.validatedRequests = filterRequests("SEARCH_BY_STATE",RequestState.VALIDATED,state)
        if(state?.displayForm?.contains('Last'))
            requestMap.lastRequests = filterRequests("SEARCH_BY_LAST_INTERVENING_AGENT_ID",
                    SecurityContext.currentUserId,state)
        
        render (view:'taskBoard', model:["requestMap":requestMap,
                                         "state" : state,
                                         "currentUserId" : SecurityContext.currentUserId,
                                         "pageState" : pageState.encodeAsHTML(),
                                         "allCategories":categoryService.getAll(),
                                         "allRequestTypes":translatedAndSortRequestTypes()])
    }
    
    def translatedAndSortRequestTypes() {
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([id:it.id, label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()])
        }
        return allRequestTypesTranslated.sort{it.label}
    }
    
    def initSearchReferential() {
        return ['allStates':RequestState.allRequestStates,
                'allAgents':agentService.getAll(),
                'allCategories':categoryService.getAll(),
                'allRequestTypes':translatedAndSortRequestTypes()]
    }
    
    protected filterRequests = {attr,val,state ->
        Set criteriaSet = new HashSet<Critere>()
        Critere critere = new Critere()
        
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request."${attr}"
        critere.value = val
        criteriaSet.add(critere)
        
        if(state?.filters?.categoryFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_CATEGORY_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.filters.categoryFilter
            criteriaSet.add(critere)
        }
        if(state?.filters?.requestTypeIdFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.filters.requestTypeIdFilter
            criteriaSet.add(critere)
        }
        return [
            'all' : defaultRequestService.get(criteriaSet, null, null, tasksShowNb, 0),
            'count' : defaultRequestService.getCount(criteriaSet)
        ]
    }
}