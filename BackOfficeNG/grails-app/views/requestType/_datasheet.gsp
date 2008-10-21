<div>
  <form id="requestForm_${requestForm?.getId()}" 
        method="post" class="form-list-edition" 
        action="${createLink(action:'requestFormDatasheet')}">
    <p>
      <label for="shortlabel" class="required">
        <g:message code="requestType.property.formShortLabel" /> * :
      </label>
      <input name="shortLabel" id="shortLabel" 
        type="text" value="${requestForm?.getShortLabel()}" />
    </p>
        
    <p>
      <label for="label" class="required">
        <g:message code="requestType.property.formLabel" /> * :
      </label>
      <input name="label" id="label" type="text" value="${requestForm?.getLabel()}" />
    </p>
      
    <p>
      <label for="templateName" class="required">
        <g:message code="requestType.property.formTemplateName" /> * :
      </label>
      <g:select
        optionKey="name"
        optionValue="name"
        name="templateName" 
        from="${templates}" 
        value="${requestForm?.getTemplateName()}" />
    </p>
      <input type="hidden" name="currentTemplateName" value="${requestForm?.getTemplateName()}" />
      <input type="hidden" name="requestFormId" value="${requestForm?.getId()}" />
      <input type="hidden" name="requestTypeId" value="" />
      <g:if test="${requestForm?.getId()}">
        <a id="a-personalize:${requestForm?.getId()}" href="javascript:;">
          ${message(code:'action.personalize')}
        </a>
      </g:if>
    
    <div class="form-button">
      <input id="button-ok" name="button-ok" type="button" 
        value="${message(code:'action.ok')}" /> 
      <input id="button-cancel" name="button-cancel" type="button" 
        value="${message(code:'action.cancel')}" />
    </div>
  </form>
</div>