


  
    <label for="alertPhone" class="required"><g:message code="hsr.property.alertPhone.label" /> *  <span><g:message code="hsr.property.alertPhone.help" /></span></label>
            <input type="text" id="alertPhone" name="alertPhone" value="${rqt.alertPhone?.toString()}" 
                    class="required autofill-subjectMobilePhone-listener-mobilePhone validate-phone ${stepStates != null && stepStates['contactphone']?.invalidFields?.contains('alertPhone') ? 'validation-failed' : ''}" title="<g:message code="hsr.property.alertPhone.validationError" />"  maxlength="10" />
            

  

