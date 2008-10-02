import fr.cg95.cvq.business.authority.Category
import fr.cg95.cvq.business.authority.CategoryProfile
import fr.cg95.cvq.exception.*
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.request.IRequestService

import grails.converters.JSON

class CategoryController {
    
    ICategoryService categoryService
    IAgentService agentService
    IRequestService defaultRequestService
    
    def translationService
    
    def defaultAction = "list"
    
    def beforeInterceptor = { session["currentMenu"] = "category" }

    def list = {
        log.debug "list() returning all categories"
        def categories = categoryService.getAll()
        // hack to load request types
        categories.each { it.requestTypes.label }

        return ["categories":categories]
    }
    
    def edit = {
        if (params.categoryId != null && params.categoryId != "")
           params.id = params.categoryId
           
        def category = categoryService.getById(Long.valueOf(params.id))
        def categories = categoryService.getAll()
        return [editMode:"edit", categories:categories, category:category]
    }
    
    def create = {
        render(view:'edit',model:[editMode:"create", categories:categoryService.getAll()])
    }
    
    def save = {
        def category = null
        def create = true
		    try {
		        if (params.id != null && params.id != "") {
		            category = categoryService.getById(Long.valueOf(params.id))
                bindData(category, params)
		            categoryService.modify(category)
		            create = false
		        } else {
		            category = new Category()
		            bindData(category, params)
		            categoryService.create(category)
		        }
		    } catch (CvqModelException cme) {
		        log.error "save() a category with the same name already exists"
		        render ([status: "error", error_msg:message(code:"category.error.nameAlreadyExists")] as JSON)
		    } catch (CvqException ce) {
			      log.error "save() error while creating category"
		        render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
		    }
		    
		    render ([status:"ok", id: category.id, name:category.name, create:create] as JSON)
    }
    
    def delete = {
        log.debug "delete() deleting category ${params.id}"
        try {
            categoryService.delete(Long.valueOf(params.id))
        } catch (CvqObjectNotFoundException cme) {
            log.error "delete() category ${params.id} has not been found"
            render ([status: "error", error_msg:message(code:"category.error.notFound")] as JSON)
        } catch (CvqException ce) {
            log.error "delete() error while creating category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
        render ([status:"ok", id:params.id, success_msg:message(code:"category.message.confirmDelete")] as JSON)
    }
    
    def loadCategoryForm = {
        def category = null
        def create = true
        if (params.id) {
            category = categoryService.getById(Long.valueOf(params.id))
            create = false
        }
        render(template:"categoryForm",model:[category:category, editMode:create ? "create" : "edit"])
    }
    
    // return the template used to display a category in the categories menu
	  def loadCategoryMenuItem = {
        def category = categoryService.getById(Long.valueOf(params.id))
        render(template:"categoryItem", model:[id:category.id,name:category.name])
    }

    /* Category requestType managment
     * --------------------------------------------------------------------- */
    
    def requestTypes = {
        def requestTypes = []
        if (request.post && params.scope == null) {
            // FIXME :  sort only all requestType (not category requestType)
            defaultRequestService.getAllRequestTypes().each{ requestTypes.add(adaptRequestType(it)) }
            
            if (params.orderRequestTypeBy == "label")
                requestTypes = requestTypes.sort{ it.label }
            else if (params.orderRequestTypeBy == "categoryName")
                requestTypes = requestTypes.sort{ it.categoryName != null ? it.categoryName : "zzz" }
        }
        else if (params.scope == "All")
            defaultRequestService.getAllRequestTypes().each{ requestTypes.add(adaptRequestType(it)) }
        else if (params.scope == "Category")
            categoryService.getById(Long.valueOf(params.id)).getRequestTypes().each {
                requestTypes.add(adaptRequestType(it))
            }

        render( template:"categoryRequests",
                model:[ categoryId: new Long(params.id), requestTypes: requestTypes ])
    }
    
    def associateRequestType = {
        try {
            def category = 
            	categoryService.addRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))

			      render ([status:"ok",categoryName:category.name, success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            log.error "associateRequestType() error while associating request type to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }

    def unassociateRequestType = {
        try {
            def category = 
                categoryService.removeRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))

    		    render ([status:"ok",categoryName:"", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            log.error "associateRequestType() error while unassociating request type from category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }
    
    /* Category agent managment
     * --------------------------------------------------------------------- */
    
    def agents = {
        def agents = []
        if (request.post && params.scope == null) {
            // FIXME : sortAgent sort only all agent (not category agent)
            agentService.getAll().each { agents.add(adaptAgent(it)) }
            
            if (params.orderAgentBy == "lastName")
                agents = agents.sort{ it.lastName }
        } 
        else if (params.scope == "All")
            agentService.getAll().each { agents.add(adaptAgent(it)) }
        else if (params.scope == "Category")
            agentService.getAuthorizedForCategory(Long.valueOf(params.id)).each {
                agents.add(adaptAgent(it))
            }
            
        render( template: "categoryAgents", 
                model: [ "categoryId": new Long(params.id), "agents": agents])
    }
    
    def unassociateAgent = {
        log.debug "unassociateAgent() unassociating agent ${params.agentId} to ${params.categoryId}"    
        try {
            agentService.removeCategoryRole(Long.valueOf(params.agentId), Long.valueOf(params.categoryId))

    		    render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
        	  log.error "unassociateAgent() error while unassociating agent to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }            
    }
    
    def editAgent = {
        if (request.get) {
            def agent = agentService.getById(Long.valueOf(params.agentId));
            def profiles = []
            CategoryProfile.allCategoryProfiles.each { profiles.add(adaptCategoryProfile(it)) }
            
            render( template: "categoryAgentEdit",
                model: [categoryId: new Long(params.id), agent: adaptAgent(agent), profiles: profiles])
        }
        
        if (request.post) {
            if (params.agentId == null || params.categoryId == null)
                render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            
            try {
            	  agentService.modifyCategoryRole(
            	        Long.valueOf(params.agentId), 
            	        Long.valueOf(params.categoryId),
            	        getProfileFromIndex(Integer.valueOf(params.profileIndex)))

        		    render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
            } catch (CvqException ce) {
                log.error "editAgent() error while editAgent agent to category"
                render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            }
        }
    }
    
    /* Adapt closure
     * --------------------------------------------------------------------- */
    
    def adaptRequestType (requestType) {
        return [
            id: requestType.id,
            active: requestType.active,
            label: translationService.getEncodedRequestTypeLabelTranslation(requestType.label),
            categoryId: requestType.category?.id, 
            categoryName: requestType.category?.name
        ]
    }
    
    def adaptAgent (businessAgent) {
        def matchingCategorieRole = businessAgent.categoriesRoles.find {
                it.category.id == Long.valueOf(params.id)
        }
        return [
            id: businessAgent.id,
            active: businessAgent.active,
            login: businessAgent.login,
            firstName: businessAgent.firstName,
            lastName: businessAgent.lastName,
            profile: matchingCategorieRole != null ? adaptCategoryProfile(matchingCategorieRole.profile) : null,
            notBelong: matchingCategorieRole == null ? true : false
        ]
    }
    
    // TODO - use CapdematUtils 
    // TODO - modify CategoryProfile enum definition to respect string convention
    def adaptCategoryProfile(categoryProfile) {
        def cssClass
        def i18nKey
        if (categoryProfile == CategoryProfile.READ_ONLY) {
   	        i18nKey = "category.profile.readOnly"
   	        cssClass = "tag-read_only"
   	    }
   	    else if (categoryProfile == CategoryProfile.READ_WRITE) {
   	        i18nKey = "category.profile.readWrite"
   	        cssClass = "tag-read_write"
   	    }
   	    else if (categoryProfile == CategoryProfile.MANAGER) {
            i18nKey = "category.profile.manager"
            cssClass = "tag-manager"
        }
        return [ i18nKey: i18nKey, cssClass: cssClass ]         
    }
    
    def getProfileFromIndex(index) {
    	  return CategoryProfile.allCategoryProfiles[index]
    }
}

