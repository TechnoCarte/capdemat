


  
    <label for="voiePietonne" class="required"><g:message code="psrr.property.voiePietonne.label" /> *  <span><g:message code="psrr.property.voiePietonne.help" /></span></label>
            <input type="text" id="voiePietonne" name="voiePietonne" value="${rqt.voiePietonne?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['complement']?.invalidFields.contains('voiePietonne') ? 'validation-failed' : ''}" title="<g:message code="psrr.property.voiePietonne.validationError" />"   />
            

  

