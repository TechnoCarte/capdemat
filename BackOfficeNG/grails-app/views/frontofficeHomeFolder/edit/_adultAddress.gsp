<form id="adultAddress_${adult.id}" method="post" action="${g.createLink(action:'editAdult', fragment:'address')}">

  <div class="address required ${invalidFields?.contains('address') ? 'validation-failed' : ''}">
    <label for="address.additionalDeliveryInformation">${message(code:'address.property.additionalDeliveryInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalDeliveryInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalDeliveryInformation" name="address.additionalDeliveryInformation"
        value="${adult.address?.additionalDeliveryInformation}" />
    <label for="address.additionalGeographicalInformation">${message(code:'address.property.additionalGeographicalInformation')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.additionalGeographicalInformation') ? 'validation-failed' : ''}" maxlength="38" id="address.additionalGeographicalInformation" name="address.additionalGeographicalInformation"
        value="${adult.address?.additionalGeographicalInformation}" />
    <label for="address.streetNumber">${message(code:'address.property.streetNumber')}</label> -
    <label for="address.streetName" class="required">${message(code:'address.property.streetName')} *</label><br />
    <input type="text" class="line1 validate-streetNumber ${invalidFields?.contains('address.streetNumber') ? 'validation-failed' : ''}" size="5" maxlength="5" id="address.streetNumber" name="address.streetNumber"
        value="${adult?.address?.streetNumber}" />
    <input type="text" class="line2 required validate-streetName ${invalidFields?.contains('address.streetName') ? 'validation-failed' : ''}" maxlength="32" id="address.streetName" name="address.streetName" title="${message(code:'address.property.streetName.validationError')}"
        value="${adult.address?.streetName}" />
    <label for="address.placeNameOrService">${message(code:'address.property.placeNameOrService')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.placeNameOrService') ? 'validation-failed' : ''}" maxlength="38" id="address.placeNameOrService" name="address.placeNameOrService"
        value="${adult.address?.placeNameOrService}" />
    <label for="address.postalCode" class="required">${message(code:'address.property.postalCode')} * </label> -
    <label for="address.city" class="required">${message(code:'address.property.city')} *</label><br />
    <input type="text" class="line1 required validate-postalCode ${invalidFields?.contains('address.postalCode') ? 'validation-failed' : ''}" size="5" maxlength="5" id="address.postalCode" name="address.postalCode" title="${message(code:'address.property.postalCode.validationError')}"
        value="${adult.address?.postalCode}" />
    <input type="text" class="line2 required validate-city ${invalidFields?.contains('address.city') ? 'validation-failed' : ''}" maxlength="32" id="address.city" name="address.city" title="${message(code:'address.property.city.validationError')}"
        value="${adult.address?.city}" />
    <label for="address.countryName">${message(code:'address.property.countryName')}</label>
    <input type="text" class="validate-addressLine38 ${invalidFields?.contains('address.countryName') ? 'validation-failed' : ''}" maxlength="38" id="address.countryName" name="address.countryName"
        value="${adult.address?.countryName}" />
  </div>

  <dt>&nbsp;</dt>
  <dd>
    <a href="${createLink(action:'adult', params:['id':adult.id, 'mode':'static'])}#address">${message(code:'action.cancel')}</a>
    <input type="hidden" name="mode" value="${mode}" />
    <input type="hidden" name="id" value="${adult.id}" />
    <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
  </dd>
</form>
