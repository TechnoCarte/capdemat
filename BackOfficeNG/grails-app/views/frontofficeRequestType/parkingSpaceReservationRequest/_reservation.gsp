


  
    <label for="requesterFirstAddressKind" class="required"><g:message code="psrr.property.requesterFirstAddressKind.label" /> *  <span><g:message code="psrr.property.requesterFirstAddressKind.help" /></span></label>
            <select id="requesterFirstAddressKind" name="requesterFirstAddressKind" class="required  validate-not-first ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddressKind') ? 'validation-failed' : ''}" title="<g:message code="psrr.property.requesterFirstAddressKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Current','Future']}">
                <option value="fr.cg95.cvq.business.request.urbanism.AccountAddressKindType_${it}" ${it == rqt.requesterFirstAddressKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="psrr.property.requesterFirstAddressKind" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="psrr.property.requesterFirstAddress.label" /> *  <span><g:message code="psrr.property.requesterFirstAddress.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress') ? 'validation-failed' : ''}">
            <label for="requesterFirstAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.additionalDeliveryInformation}" maxlength="38" id="requesterFirstAddress.additionalDeliveryInformation" name="requesterFirstAddress.additionalDeliveryInformation" />  
            <label for="requesterFirstAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.additionalGeographicalInformation}" maxlength="38" id="requesterFirstAddress.additionalGeographicalInformation" name="requesterFirstAddress.additionalGeographicalInformation" />
            <label for="requesterFirstAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="requesterFirstAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.streetNumber}" size="5" maxlength="5" id="requesterFirstAddress.streetNumber" name="requesterFirstAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.streetName}" maxlength="32" id="requesterFirstAddress.streetName" name="requesterFirstAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="requesterFirstAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.placeNameOrService}" maxlength="38" id="requesterFirstAddress.placeNameOrService" name="requesterFirstAddress.placeNameOrService" />
            <label for="requesterFirstAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="requesterFirstAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.postalCode}" size="5" maxlength="5" id="requesterFirstAddress.postalCode" name="requesterFirstAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.city') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.city}" maxlength="32" id="requesterFirstAddress.city" name="requesterFirstAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="requesterFirstAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterFirstAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.requesterFirstAddress?.countryName}" maxlength="38" id="requesterFirstAddress.countryName" name="requesterFirstAddress.countryName" />
            </div>
            

  

  
    <label for="requesterOtherAddressKind" class="required"><g:message code="psrr.property.requesterOtherAddressKind.label" /> *  <span><g:message code="psrr.property.requesterOtherAddressKind.help" /></span></label>
            <select id="requesterOtherAddressKind" name="requesterOtherAddressKind" class="required  validate-not-first ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddressKind') ? 'validation-failed' : ''}" title="<g:message code="psrr.property.requesterOtherAddressKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Current','Future']}">
                <option value="fr.cg95.cvq.business.request.urbanism.AccountAddressKindType_${it}" ${it == rqt.requesterOtherAddressKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="psrr.property.requesterOtherAddressKind" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="psrr.property.requesterOtherAddress.label" /> *  <span><g:message code="psrr.property.requesterOtherAddress.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress') ? 'validation-failed' : ''}">
            <label for="requesterOtherAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.additionalDeliveryInformation}" maxlength="38" id="requesterOtherAddress.additionalDeliveryInformation" name="requesterOtherAddress.additionalDeliveryInformation" />  
            <label for="requesterOtherAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.additionalGeographicalInformation}" maxlength="38" id="requesterOtherAddress.additionalGeographicalInformation" name="requesterOtherAddress.additionalGeographicalInformation" />
            <label for="requesterOtherAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="requesterOtherAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.streetNumber}" size="5" maxlength="5" id="requesterOtherAddress.streetNumber" name="requesterOtherAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.streetName}" maxlength="32" id="requesterOtherAddress.streetName" name="requesterOtherAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="requesterOtherAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.placeNameOrService}" maxlength="38" id="requesterOtherAddress.placeNameOrService" name="requesterOtherAddress.placeNameOrService" />
            <label for="requesterOtherAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="requesterOtherAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.postalCode}" size="5" maxlength="5" id="requesterOtherAddress.postalCode" name="requesterOtherAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.city') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.city}" maxlength="32" id="requesterOtherAddress.city" name="requesterOtherAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="requesterOtherAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['reservation']?.invalidFields.contains('requesterOtherAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.requesterOtherAddress?.countryName}" maxlength="38" id="requesterOtherAddress.countryName" name="requesterOtherAddress.countryName" />
            </div>
            

  

  
    <label class="required"><g:message code="psrr.property.furnitureLift.label" /> *  <span><g:message code="psrr.property.furnitureLift.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['reservation']?.invalidFields.contains('furnitureLift') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="furnitureLift_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="furnitureLift" ${it == rqt.furnitureLift ? 'checked="checked"': ''} />
                <label for="furnitureLift_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="psrr.property.startDate.label" /> *  <span><g:message code="psrr.property.startDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['reservation']?.invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_day"
                name="startDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.startDate?.date == it
                      || (rqt.startDate == null && params['startDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['reservation']?.invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_month"
                name="startDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.startDate?.month == (it - 1)
                      || (rqt.startDate == null && params['startDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['reservation']?.invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_year"
                name="startDate_year"
                value="${rqt.startDate ? rqt.startDate.year + 1900 : params['startDate_year']}"
                title="<g:message code="psrr.property.startDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="psrr.property.duration.label" /> *  <span><g:message code="psrr.property.duration.help" /></span></label>
            <g:set var="durationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'duration', 'i18nPrefixCode':'psrr.property.duration', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.duration.entries, 'depth':0]" />
            

  

