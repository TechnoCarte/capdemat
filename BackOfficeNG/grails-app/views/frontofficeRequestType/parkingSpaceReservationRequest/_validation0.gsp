


  
    <h3><g:message code="psrr.step.requester.label" /></h3>
    
      
      <dl>
        
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          

      </dl>
      
    
  

  
    <h3><g:message code="psrr.step.reservation.label" /></h3>
    
      
      <dl>
        <dt><g:message code="psrr.property.requesterFirstAddressKind.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterFirstAddressKind}">
              <g:capdematEnumToField var="${rqt.requesterFirstAddressKind}" i18nKeyPrefix="psrr.property.requesterFirstAddressKind" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.requesterFirstAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.requesterFirstAddress}">
              <p>${rqt.requesterFirstAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.requesterFirstAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.requesterFirstAddress?.streetNumber} ${rqt.requesterFirstAddress?.streetName}</p>
              <p>${rqt.requesterFirstAddress?.placeNameOrService}</p>
              <p>${rqt.requesterFirstAddress?.postalCode} ${rqt.requesterFirstAddress?.city}</p>
              <p>${rqt.requesterFirstAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.requesterOtherAddressKind.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterOtherAddressKind}">
              <g:capdematEnumToField var="${rqt.requesterOtherAddressKind}" i18nKeyPrefix="psrr.property.requesterOtherAddressKind" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.requesterOtherAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.requesterOtherAddress}">
              <p>${rqt.requesterOtherAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.requesterOtherAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.requesterOtherAddress?.streetNumber} ${rqt.requesterOtherAddress?.streetName}</p>
              <p>${rqt.requesterOtherAddress?.placeNameOrService}</p>
              <p>${rqt.requesterOtherAddress?.postalCode} ${rqt.requesterOtherAddress?.city}</p>
              <p>${rqt.requesterOtherAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.furnitureLift.label" /></dt>
          <dd><g:message code="message.${rqt.furnitureLift ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.startDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.startDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="psrr.property.duration.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'duration', 'lrEntries': lrTypes.duration.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="psrr.step.complement.label" /></h3>
    
      
      <dl>
        <dt><g:message code="psrr.property.voiePietonne.label" /></dt><dd>${rqt.voiePietonne?.toString()}</dd>

      </dl>
      
    
  

  


