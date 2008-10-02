  <h1>
    <span class="${request.state.cssClass}">
      <g:message code="${request.state.i18nKey}" />
    </span>
    <span><g:message code="request.property.state" /> :&nbsp;</span>
    <g:message code="request.contact.header.contactEcitzen" /> 
  </h1>
  <div class="mainbox mainbox-yellow">
    <h2><g:message code="request.contact.header.writeMessage" /> </h2>
    
    <form method="POST" id="contactForm" action="<g:createLink action="notifyContact" />">
      <div class="error" id="contactFormErrors"></div>
      <fieldset>
        <label for="meansOfContact" ><g:message code="request.contact.meansOfContact" /></label>
        <select name="meansOfContact">
          <g:each var="moc" in="${requesterMeansOfContacts}">
          <option value="${moc.enumString}" ${moc.enumString == request.meansOfContact.enumString ? 'selected="selected"' : ''}>
              ${moc.i18nKey}
          </option>
          </g:each>
        </select>
        
        <input type="hidden" id="requesterEmail" name="requesterEmail" value="${request.requesterEmail}" />
        <input type="hidden" id="requesterMobilePhone" name="requesterMobilePhone" value="${request.requesterMobilePhone}" />
        
        <label for="contactReciepient" class="required">
          <g:message code="request.contact.contactReciepient" />
        </label>
        <input type="text" id="contactReciepient" name="contactReciepient" size="55" class="required"
                value="${defaultContactReciepient}" />
      </fieldset>
      
      <label for="contactMessage" class="required"><g:message code="request.contact.message" /></label>
      <textarea name="contactMessage" rows="5" cols="53" class="required"></textarea>

      <fieldset>
        <label for="requestForm"><g:message code="request.contact.mailTemplate" /></label>
        <select name="requestForm">
          <g:each var="rf" in="${requestForms}">
          <!-- to be replaced by shortLabel -->
          <option value="${rf.id}">${rf.xslFoFilename}</option>
          </g:each>
        </select>
        <a href=""><g:message code="request.contact.preview" /></a>
        
        <hr />
        
        <label for="contactAttachment"><g:message code="request.contact.attachToEmail" /></label>
        <input type="checkbox" name="contactAttachment" value="joinPdfMail" />
      </fieldset>
      
      <input type="button" id="submitContactForm" name="submitContactForm" class="form-button" 
          value="<g:message code="request.contact.send" />" />
      <input type="button" id="discardContactForm" name="discardContactForm" 
          value="<g:message code="request.contact.discard" />" />
      
    </form>
  </div>
