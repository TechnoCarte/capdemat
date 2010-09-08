


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="psrr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="psrr.step.reservation.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="psrr.step.complement.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="psrr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <g:render template="/backofficeRequestInstruction/requestType/requester" model="['requester':requester]" />
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="psrr.step.reservation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.requesterFirstAddressKind.label" /> * : </dt><dd id="requesterFirstAddressKind" class="action-editField validate-capdematEnum required-true i18n-psrr.property.requesterFirstAddressKind javatype-fr.cg95.cvq.business.request.urbanism.AccountAddressKindType" ><g:capdematEnumToField var="${rqt?.requesterFirstAddressKind}" i18nKeyPrefix="psrr.property.requesterFirstAddressKind" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.requesterFirstAddress.label" /> * : </dt><dd id="requesterFirstAddress" class="action-editField validate-address required-true i18n-psrr.property.requesterFirstAddress" ><div><p class="additionalDeliveryInformation">${rqt?.requesterFirstAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.requesterFirstAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.requesterFirstAddress?.streetNumber}</span> <span class="streetName">${rqt?.requesterFirstAddress?.streetName}</span><p class="placeNameOrService">${rqt?.requesterFirstAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.requesterFirstAddress?.postalCode}</span> <span class="city">${rqt?.requesterFirstAddress?.city}</span><p class="countryName">${rqt?.requesterFirstAddress?.countryName}</p></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.requesterOtherAddressKind.label" /> * : </dt><dd id="requesterOtherAddressKind" class="action-editField validate-capdematEnum required-true i18n-psrr.property.requesterOtherAddressKind javatype-fr.cg95.cvq.business.request.urbanism.AccountAddressKindType" ><g:capdematEnumToField var="${rqt?.requesterOtherAddressKind}" i18nKeyPrefix="psrr.property.requesterOtherAddressKind" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.requesterOtherAddress.label" /> * : </dt><dd id="requesterOtherAddress" class="action-editField validate-address required-true i18n-psrr.property.requesterOtherAddress" ><div><p class="additionalDeliveryInformation">${rqt?.requesterOtherAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.requesterOtherAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.requesterOtherAddress?.streetNumber}</span> <span class="streetName">${rqt?.requesterOtherAddress?.streetName}</span><p class="placeNameOrService">${rqt?.requesterOtherAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.requesterOtherAddress?.postalCode}</span> <span class="city">${rqt?.requesterOtherAddress?.city}</span><p class="countryName">${rqt?.requesterOtherAddress?.countryName}</p></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.furnitureLift.label" /> * : </dt><dd id="furnitureLift" class="action-editField validate-boolean required-true i18n-psrr.property.furnitureLift" ><span class="value-${rqt?.furnitureLift}"><g:message code="message.${rqt?.furnitureLift ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.startDate.label" /> * : </dt><dd id="startDate" class="action-editField validate-date required-true i18n-psrr.property.startDate" ><span><g:formatDate formatName="format.date" date="${rqt?.startDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.duration.label" /> * : </dt><dd id="duration" class="action-editField validate-localReferentialData required-true i18n-psrr.property.duration data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'duration', 'lrEntries': lrTypes.duration?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.duration?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="psrr.step.complement.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="psrr.property.voiePietonne.label" /> * : </dt><dd id="voiePietonne" class="action-editField validate-string required-true i18n-psrr.property.voiePietonne" ><span>${rqt?.voiePietonne}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
