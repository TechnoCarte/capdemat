


  
    <label class="required"><g:message code="tbr.property.isSubscriber.label" /> *  <span><g:message code="tbr.property.isSubscriber.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['entertainments']?.invalidFields.contains('isSubscriber') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isSubscriber_${it ? 'yes' : 'no'}" class="required condition-hasSubscriberNumber-trigger  validate-one-required boolean" title="" value="${it}" name="isSubscriber" ${it == rqt.isSubscriber ? 'checked="checked"': ''} />
                <label for="isSubscriber_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="subscriberNumber" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberNumber.label" /> *  <span><g:message code="tbr.property.subscriberNumber.help" /></span></label>
            <input type="text" id="subscriberNumber" name="subscriberNumber" value="${rqt.subscriberNumber?.toString()}" 
                    class="required condition-hasSubscriberNumber-filled  validate-token ${stepStates != null && stepStates['entertainments']?.invalidFields.contains('subscriberNumber') ? 'validation-failed' : ''}" title="<g:message code="tbr.property.subscriberNumber.validationError" />"   />
            

  

  
    <label for="subscriberFirstName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberFirstName.label" /> *  <span><g:message code="tbr.property.subscriberFirstName.help" /></span></label>
            <input type="text" id="subscriberFirstName" name="subscriberFirstName" value="${rqt.subscriberFirstName?.toString()}" 
                    class="required condition-hasSubscriberNumber-filled  validate-string ${stepStates != null && stepStates['entertainments']?.invalidFields.contains('subscriberFirstName') ? 'validation-failed' : ''}" title="<g:message code="tbr.property.subscriberFirstName.validationError" />"   />
            

  

  
    <label for="subscriberLastName" class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberLastName.label" /> *  <span><g:message code="tbr.property.subscriberLastName.help" /></span></label>
            <input type="text" id="subscriberLastName" name="subscriberLastName" value="${rqt.subscriberLastName?.toString()}" 
                    class="required condition-hasSubscriberNumber-filled  validate-string ${stepStates != null && stepStates['entertainments']?.invalidFields.contains('subscriberLastName') ? 'validation-failed' : ''}" title="<g:message code="tbr.property.subscriberLastName.validationError" />"   />
            

  

