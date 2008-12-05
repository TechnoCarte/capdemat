

import fr.cg95.cvq.business.request.social.DomesticHelpRequest
import fr.cg95.cvq.service.request.social.IDomesticHelpRequestService

class DomesticHelpRequestController {

    DomesticHelpRequest dhr 
    IDomesticHelpRequestService domesticHelpRequestService
   
    def translationService
    
    def defaultAction = "edit"
    
    def currentTab = "tab1"
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
    
    def edit = {
        if (dhr == null)
          dhr = new DomesticHelpRequest()
          
        session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
        	model:[dhr:dhr, currentTab:currentTab,translationService:translationService])
    }
    
    
    def validSubject = {
    	log.debug("validSubject - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    def validDwelling = {
    	log.debug("validDwelling - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    def validResources = {
    	log.debug("validResources - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    def validTaxes = {
    	log.debug("validTaxes - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    def validDefault_step_ref_document = {
    	log.debug("validDefault_step_ref_document - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    def validDefault_step_ref_validation = {
    	log.debug("validDefault_step_ref_validation - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", model:[dhr:dhr, currentTab:currentTab, translationService:translationService])
    }
    
    
    
    def getCurrentTab = { currentTab ->
	
		if (params.submitDhrSubject)
		   currentTab = "tab1"
	
		else if (params.submitDhrDwelling)
		   currentTab = "tab2"
	
		else if (params.submitDhrResources)
		   currentTab = "tab3"
	
		else if (params.submitDhrTaxes)
		   currentTab = "tab4"
	
		else if (params.submitDhrDefault_step_ref_document)
		   currentTab = "tab5"
	
		else if (params.submitDhrDefault_step_ref_validation)
		   currentTab = "tab6"
	
		return currentTab
    } 
    
    def checkConditions = {
    	log.debug("checkConditions - START")
    	def conditions = new HashMap();
    	params.each {
    		if (it.key.contains("cn_")) {
    			conditions.put(it.value, new HashMap())
    		}	
    	}
    	params.each {
    	  def currentParam = it
    	  conditions.each {
    	    if (currentParam.key.contains(it.key) && !currentParam.key.contains("cn_")) {
    	      def triggerName = currentParam.key.substring(currentParam.key.indexOf("_") + 1, currentParam.key.length())
    	      conditions.get(it.key).put(triggerName, currentParam.value)
    	    }
    	  }
    	}
    	def args = [conditions]
    	render domesticHelpRequestService.invokeMethod("areConditionsFilled", args as Object[])
    }
    
}