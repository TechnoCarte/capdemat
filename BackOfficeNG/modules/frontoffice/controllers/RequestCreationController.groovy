import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Address
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.exception.CvqException

import grails.converters.JSON

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestCreationController {
    
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    
    def translationService
    def defaultAction = 'edit'
    
    def draft = {
        def requestService = requestServiceRegistry.getRequestService(
            params.requestTypeLabel.toString()
        )
        
        if(request.post) {
            def cRequest = session[params.uuidString].cRequest
            requestService.prepareDraft(cRequest)
            requestService.processDraft(cRequest)
            flash.cRequest = cRequest
            flash.confirmationMessage = message(code:'message.savedAsDraft')
        } else if (request.get) {
            flash.cRequest = requestService.getById(Long.parseLong(params.id))
        }
        redirect(controller:controllerName, params:['label':params.requestTypeLabel])
        return false
    }
    
    def edit = {
        if (params.label == null)
            redirect(uri: '/frontoffice/requestType')

        def requestService = requestServiceRegistry.getRequestService(params.label)
        
        def cRequest
        if (flash.cRequest) cRequest = flash.cRequest 
        else cRequest = requestService.getSkeletonRequest()
        
        def uuidString = UUID.randomUUID().toString()
        
        session[uuidString] = [:]
        session[uuidString].put('cRequest', cRequest)
        
        render( view: 'frontofficeRequestType/domesticHelpRequest/edit', 
                model:
                    ['rqt': cRequest, 
                    'subjects': getAuthorizedSubjects(requestService, cRequest),
                    'documentTypes': getDocumentTypes(requestService),
                    'meansOfContact': getMeansOfContact(meansOfContactService),
                    'currentStep': 'subject',
                    'requestTypeLabel': params.label,
                    'uuidString': uuidString
                    ])
    }
    

    def step = {
        log.debug('POST step() - start')
        
        if (params.requestTypeInfo == null || params.uuidString == null)
            redirect(uri: '/frontoffice/requestType')
            
        def uuid = params.uuidString
        def requestTypeInfo = JSON.parse(params.requestTypeInfo)
        
        def currentStep
        def submitAction
        def editList
        
        def requestService = requestServiceRegistry.getRequestService(requestTypeInfo.label)
        def cRequest = session[uuid].cRequest

        params.each {
              if (it.key.startsWith('submit-'))
                submitAction = it.key.tokenize('-')
        }

        currentStep = submitAction[2]
        
        if (submitAction[1] == 'delete') {
            def listFieldToken = submitAction[3].tokenize('[]')
            def getterMethod = cRequest.class.getMethod(
                    'get' + StringUtils.firstCase(listFieldToken[0], 'Upper'))
                    
            getterMethod.invoke(cRequest, null).remove(Integer.valueOf(listFieldToken[1]).intValue())
        }
        else if (submitAction[1] == 'edit') {
            def listFieldToken = submitAction[3].tokenize('[]')
            def getterMethod = cRequest.class.getMethod(
                    'get' + StringUtils.firstCase(listFieldToken[0], 'Upper'))
                    
            editList = ['name': listFieldToken[0], 
                        'index': listFieldToken[1],
                        (listFieldToken[0]): getterMethod.invoke(cRequest, null).get(Integer.valueOf(listFieldToken[1]).intValue())
                       ]
        }
        else {
            if (submitAction[1] != 'modify')
                initBind(cRequest, params)
            bind(cRequest)
            
            if (session[uuid].stepStates == null) {
                session[uuid].stepStates = [:]
                requestTypeInfo.steps.each {
                    session[uuid].stepStates.put(it, ['cssClass': 'tag-uncomplete', 'i18nKey': 'request.step.state.uncomplete'])
                }
            }
            
            if (submitAction[1] == 'step') {
                session[uuid].stepStates.get(currentStep).cssClass = 'tag-complete'
                session[uuid].stepStates.get(currentStep).i18nKey = 'request.step.state.complete'
            }
            
            if (currentStep == "validation") {
                if (!cRequest.draft) requestService.create(cRequest)
                else requestService.finalizeDraft(cRequest)
            }
        }
        
        session[uuid].cRequest = cRequest

        render( view: 'frontofficeRequestType/domesticHelpRequest/edit',
                model:
                    ['rqt': cRequest,
                    'subjects': getAuthorizedSubjects(requestService, cRequest),
                    'documentTypes': getDocumentTypes(requestService),
                    'meansOfContact': getMeansOfContact(meansOfContactService),
                    'currentStep': currentStep,
                    'requestTypeLabel': requestTypeInfo.label,
                    'stepStates': session[uuid].stepStates,
                    'uuidString': uuid,
                    'editList': editList
                    ])
    }

    def condition = {
        if (params.requestTypeLabel == null)
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            
        def triggers = JSON.parse(params.triggers)
        try {
            def requestService = requestServiceRegistry.getRequestService(params.requestTypeLabel)
            render (
              [test: requestService.isConditionFilled(triggers)
              ,status:"ok"
              ,success_msg:message(code:"message.conditionTested")
              ] as JSON)
        } catch (CvqException ce) {
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }
    
    def getAuthorizedSubjects(requestService, cRequest) {
        def subjects = [:]
        def authorizedSubjects = requestService.getAuthorizedSubjects(SecurityContext.currentEcitizen.homeFolder.id)
        authorizedSubjects.each { subjectId, seasonsSet ->
            def subject = individualService.getById(subjectId)
            subjects[subjectId] = subject.lastName + ' ' + subject.firstName
        }
        
        if(cRequest.draft && !subjects.containsKey(cRequest.subjectId))
            subjects[cRequest.subjectId] = "${cRequest.subjectLastName} ${cRequest.subjectFirstName}"
            
        return subjects
    }
    
    def getMeansOfContact(meansOfContactService) {
        def result = []
        def meansOfContact = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact()
        meansOfContact.each {
            result.add([
                        key:it.type,
                        label: message(code:'request.meansOfContact.' + StringUtils.pascalToCamelCase(it.type.toString()))])
        }
        return result.sort {it.label}
    }
    
    def getDocumentTypes(requestService) {
        def requestType = requestService.getRequestTypeByLabel(requestService.getLabel())
        def documentTypes = requestService.getAllowedDocuments(requestType.getId())
        def result = [:]
        documentTypes.each {
            result[it.id] = CapdematUtils.adaptDocumentTypeName(it.name)
        }
        return result
    }
    
    // TODO - Share with backoffice controller
    def initBind(object, params) {
        params.each { param ->
            if (param.value.getClass() == GrailsParameterMap.class) {
                def getterName = 'get' + StringUtils.firstCase(param.key.tokenize('.')[0].tokenize('[')[0], 'Upper')
                def getterMethod = object.class.getMethod(getterName)
                
                if (getterMethod.invoke(object, null) == null) {
                    def setterMethod = object.class.getMethod(
                            'set' + StringUtils.firstCase(param.key.tokenize('.')[0].tokenize('[')[0], 'Upper')
                            ,[getterMethod.returnType] as Class[])

                    def fieldConstructor
                    if (getterMethod.returnType.equals(Class.forName('java.util.List')))
                        fieldConstructor = Class.forName('java.util.ArrayList').getConstructor()
                    else
                        fieldConstructor = getterMethod.returnType.getConstructor(null)

                    setterMethod.invoke(object, [fieldConstructor.newInstance(null)] as Object[])
                }
                
                // add a new element to list (it will be update by databinder)
                if (getterMethod.returnType.equals(Class.forName('java.util.List'))) {
                    def listElemType = getterMethod.genericReturnType.actualTypeArguments[0]
                    def listElem = listElemType.getConstructor(null).newInstance(null)
                    
                    initBind(listElem, param.value)
                    
                    getterMethod.invoke(object, null).add(listElem)
                }
            }
        }
     }
}