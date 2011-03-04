import java.text.SimpleDateFormat

import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils

import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.document.ContentType

import fr.cg95.cvq.exception.CvqObjectNotFoundException
import fr.cg95.cvq.exception.CvqInvalidTransitionException
import fr.cg95.cvq.exception.CvqException

import fr.cg95.cvq.security.PermissionException
import fr.cg95.cvq.security.SecurityContext

import fr.cg95.cvq.external.IExternalService

import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IMeansOfContactService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.document.IDocumentService

class ServiceRequestExternalController {
    
    IExternalService externalService
    IRequestDocumentService requestDocumentService
    IRequestWorkflowService requestWorkflowService
    IRequestSearchService requestSearchService
    IIndividualService individualService
    IDocumentTypeService documentTypeService
    IDocumentService documentService
    IRequestActionService requestActionService
    IMeansOfContactService meansOfContactService

    // C/C from Provisioning
    // TODO : mutualize, if possible, authentication infrastructure between both after branches merge
    def beforeInterceptor = {
        def authorization = request.getHeader("Authorization")
        if (authorization == null) {
            response.setHeader("WWW-Authenticate", "Basic")
            render(text: "", status : 401)
            return false
        }
        def credentials = StringUtils.split(new String(Base64.decodeBase64(authorization.substring(6).bytes), "8859_1"), ":")
        if (credentials == null || credentials.length < 2 
                || !externalService.authenticate(credentials[0], credentials[1])) {
            response.setHeader("WWW-Authenticate", "Basic")
            render(text: "", status : 401)
            return false
        }
        SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT)
        SecurityContext.setCurrentExternalService(credentials[0])
    }

    def requestDocuments = {
        try {
            render(text:requestDocumentService.getAssociatedFullDocuments(params.long('requestId')),
                contentType:"text/xml",encoding:"UTF-8", status: 200)
        } catch (CvqObjectNotFoundException confe) {
            render(text: "", status: 404)
        } catch (PermissionException pe) {
            render(text: "", status: 403)
        }

        return false
    }

    def requestDocument = {
        switch(request.method){
            case 'POST':
                Request rqt = requestSearchService.getById(params.long('requestId'), false)
                Adult requester = (Adult) individualService.getById(rqt.requesterId)

                DocumentType documentType = 
                    documentTypeService.getDocumentTypeByType(params.int('documentTypeId'))
                Document document = new Document(rqt.homeFolderId, null, documentType, 
                    DocumentState.PENDING)
                document.individualId = rqt.subjectId
                document.depositOrigin = DepositOrigin.AGENT
                if (params.endValidityDate != null)
                    document.endValidityDate = new SimpleDateFormat('yyyy-MM-dd').parse(params.endValidityDate)

                Long documentId = documentService.create(document)
                documentService.addPage(documentId, Base64.decodeBase64(params.data.bytes))
                documentService.validate(documentId, document.endValidityDate, '') // message unused btw
                document = documentService.getById(documentId)

                requestActionService.addAction(
                    params.long('requestId'),
                    RequestActionType.CONTACT_CITIZEN,
                    '',
                    '',
                    document.getDatas().get(0).getData(),
                    documentType.name + '.pdf'
                ) // TODO fod Translate filename

                meansOfContactService.notifyByEmail(
                    rqt.requestType.category.primaryEmail,
                    requester.email,
                    message(code: 'mail.ecitizenContact.subject'),
                    message(code: 'mail.ecitizenContact.body'),
                    document.getDatas().get(0).getData(),
                    documentType.name + '.pdf'
                ) // TODO fod Translate filename

                // TODO fod Catch exceptions!
                render(text: 'Certificate has been added', status: 200)
                return false
            case 'GET':
                try {
                    render(text: requestDocumentService.getAssociatedDocument(params.long('requestId'),
                        params.long('documentId'), params.mergeDocument ? true : false),
                        contentType: 'text/xml', encoding: 'UTF-8', status: 200)
                } catch (CvqObjectNotFoundException confe) {
                    render(text: '', status: 404)
                } catch (PermissionException pe) {
                    render(text: '', status: 403)
                }
                return false
        }
    }

    def requestState = {// handling POST; be careful : non idempotent operation
        try {
            requestWorkflowService.updateRequestState(params.long('requestId'),
                RequestState.forString(params.state), params.message)
            render(text:"request " + params.long('requestId') + "changed to " + params.state, status: 200)
        } catch (CvqObjectNotFoundException confe) {
            render(text: message(code:confe.getMessage()), status: 404)
        } catch (CvqInvalidTransitionException cite) {
            render(text: message(code:cite.getMessage()), status: 403)
        } catch (PermissionException pe) {
            render(text: message(code:pe.getMessage()), status: 403)
        } catch (CvqException ce) {
            render(text: message(code:ce.getMessage()), status: 500)
        }
        return false
    }
}
