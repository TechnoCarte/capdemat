


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="parr.property.perischoolActivity.label" /> *  <span><g:message code="parr.property.perischoolActivity.help" /></span></label>
            <g:set var="perischoolActivityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'perischoolActivity', 'i18nPrefixCode':'parr.property.perischoolActivity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.perischoolActivity.entries, 'depth':0]" />
            

  

  
    <label for="urgencyPhone" class="required"><g:message code="parr.property.urgencyPhone.label" /> *  <span><g:message code="parr.property.urgencyPhone.help" /></span></label>
            <input type="text" id="urgencyPhone" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('urgencyPhone') ? 'validation-failed' : ''}" title="<g:message code="parr.property.urgencyPhone.validationError" />"  maxlength="10" />
            

  

