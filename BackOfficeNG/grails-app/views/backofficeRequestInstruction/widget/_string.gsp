<form method="post" id="${propertyName}_Form" action="<g:createLink action="modify" />" class="editable-list-form" >
  <span id="${propertyName}_FormErrors" class="error"></span> 
  
  <input id="${propertyName}_Field" name="${propertyName}" type="text" value="${propertyValue}" 
      class="${propertyType != '' ? 'validate-' + propertyType : ''} ${required}" 
      title="<g:message code="${i18nKeyPrefix}.validationError" />"
      ${regex != '' ? ' regex="' + regex + '"' : ''}
      ${minLength != null ? ' minlength="' + minLength + '"' : ''}
      ${maxLength != null ? ' maxlength="' + maxLength + '"' : ''}
  />
  
  <input name="requestId" type="hidden" value="${requestId}" />
  <input type="button" class="submitField" value="<g:message code="action.save" />" />
  <input type="button" class="revertField" value="<g:message code="action.cancel" />" />
</form>
