


  
    <label class="required"><g:message code="sgr.property.isSubjectAccountHolder.label" /> *  <span><g:message code="sgr.property.isSubjectAccountHolder.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('isSubjectAccountHolder') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isSubjectAccountHolder_${it ? 'yes' : 'no'}" class="required condition-isSubjectAccountHolder-trigger  validate-one-required boolean" title="" value="${it}" name="isSubjectAccountHolder" ${it == rqt.isSubjectAccountHolder ? 'checked="checked"': ''} />
                <label for="isSubjectAccountHolder_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderTitle.label" /> *  <span><g:message code="sgr.property.accountHolderTitle.help" /></span></label>
            <select id="accountHolderTitle" name="accountHolderTitle" class="required condition-isSubjectAccountHolder-unfilled  validate-not-first ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('accountHolderTitle') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.accountHolderTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.accountHolderTitle" /></option>
              </g:each>
            </select>
            

  

  
    <label for="accountHolderLastName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderLastName.label" /> *  <span><g:message code="sgr.property.accountHolderLastName.help" /></span></label>
            <input type="text" id="accountHolderLastName" name="accountHolderLastName" value="${rqt.accountHolderLastName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-lastName ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('accountHolderLastName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="accountHolderFirstName" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderFirstName.label" /> *  <span><g:message code="sgr.property.accountHolderFirstName.help" /></span></label>
            <input type="text" id="accountHolderFirstName" name="accountHolderFirstName" value="${rqt.accountHolderFirstName?.toString()}" 
                    class="required condition-isSubjectAccountHolder-unfilled  validate-firstName ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('accountHolderFirstName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderFirstName.validationError" />"  maxlength="38" />
            

  

  
    <label for="accountHolderBirthDate" class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderBirthDate.label" /> *  <span><g:message code="sgr.property.accountHolderBirthDate.help" /></span></label>
            <input type="text" id="accountHolderBirthDate" name="accountHolderBirthDate" value="${formatDate(formatName:'format.date',date:rqt.accountHolderBirthDate)}" 
                   class="required condition-isSubjectAccountHolder-unfilled  validate-date ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('accountHolderBirthDate') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.accountHolderBirthDate.validationError" />" />
            

  

  
    <label for="frenchRIB" class="required"><g:message code="sgr.property.frenchRIB.label" /> *  <span><g:message code="sgr.property.frenchRIB.help" /></span></label>
            <div class="frenchRIB-fieldset required  ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('frenchRIB') ? 'validation-failed' : ''}">
            <label class="required" for="frenchRIB.bankCode"><g:message code="frenchRIB.property.bankCode" /></label>
            <input type="text" class="required ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('frenchRIB.bankCode') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.bankCode}" maxlength="5" id="frenchRIB.bankCode" name="frenchRIB.bankCode" />
            <label class="required" for="frenchRIB.counterCode"><g:message code="frenchRIB.property.counterCode" /></label>
            <input type="text" class="required ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('frenchRIB.counterCode') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.counterCode}" maxlength="5" id="frenchRIB.counterCode" name="frenchRIB.counterCode" />
            <label class="required" for="frenchRIB.accountNumber"><g:message code="frenchRIB.property.accountNumber" /></label>
            <input type="text" class="required ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('frenchRIB.accountNumber') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.accountNumber}" maxlength="11" id="frenchRIB.accountNumber" name="frenchRIB.accountNumber" />
            <label class="required" for="frenchRIB.accountNumber"><g:message code="frenchRIB.property.accountNumber" /></label>
            <input type="text" class="required ${stepStates != null && stepStates['bankReference']?.invalidFields.contains('frenchRIB.accountKey') ? 'validation-failed' : ''}" value="${rqt.frenchRIB?.accountKey}" maxlength="2" id="frenchRIB.accountKey" name="frenchRIB.accountKey" />
            </div>
            

  

