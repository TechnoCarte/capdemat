import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import grails.converters.JSON

public class SystemController {

    def error = {
        def exception = request.exception
        def currentSiteDisplayTitle = SecurityContext.currentSite.displayTitle

        try {
            HibernateUtil.rollbackTransaction();
            HibernateUtil.closeSession();
            SecurityContext.resetCurrentSite();
        } catch (Throwable e) {
        	log.error "Can't rollback hibernate transaction"
        }
        if (ExceptionUtils.isModelException(exception) && ExceptionUtils.isXRequestError(request))
            render(["status":"modelException", 
                    "message":exception.message, 
                    "i18nkey":message(code:ExceptionUtils.getModelI18nKey(exception),args:ExceptionUtils.getModelI18nArgs(exception))] as JSON)
        else if (ExceptionUtils.isPermissionException(exception) && ExceptionUtils.isXRequestError(request))
            render(["status":"modelException", 
                    "message":exception.message, 
                    "i18nkey":message(code:'error.permission')] as JSON)
        else if (session.frontContext) {
            if (ExceptionUtils.isModelException(exception)) {
                return [
                    "i18nKey" : ExceptionUtils.getModelI18nKey(exception),
                    "i18nArgs" : ExceptionUtils.getModelI18nArgs(exception)
                ]
            } else if (ExceptionUtils.isPermissionException(exception)) {
                return [
                    "i18nKey" : message(code:'error.permission'),
                    "i18nArgs" : []
                ]
            }
        } else
            render(view: "/error", 
                model:['currentSite': currentSiteDisplayTitle,
                       'errorMessage': message(code:ExceptionUtils.getModelI18nKey(exception),args:ExceptionUtils.getModelI18nArgs(exception))])
    }
}
