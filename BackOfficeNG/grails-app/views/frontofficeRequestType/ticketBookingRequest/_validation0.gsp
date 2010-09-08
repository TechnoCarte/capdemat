


  
    <h3><g:message code="tbr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="tbr.step.entertainments.label" /></h3>
    
      
      <dl>
        <dt><g:message code="tbr.property.isSubscriber.label" /></dt>
          <dd><g:message code="message.${rqt.isSubscriber ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tbr.property.subscriberNumber.label" /></dt><dd>${rqt.subscriberNumber?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tbr.property.subscriberFirstName.label" /></dt><dd>${rqt.subscriberFirstName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="tbr.property.subscriberLastName.label" /></dt><dd>${rqt.subscriberLastName?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="tbr.step.rules.label" /></h3>
    
      
      <dl>
        <dt><g:message code="tbr.property.rulesAndRegulationsAcceptance.label" /></dt>
          <dd><g:message code="message.${rqt.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  


