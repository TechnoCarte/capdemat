<%
  def object, name
  if (adult != null) {
    object = adult
    name = 'adult'
  } else if (homeFolder != null) {
    object = homeFolder
    name = 'homeFolder'
  }
%>

<%
  def individual = adult != null ? adult : child
  def className = individual.class.simpleName.toLowerCase()
%>

<form id="${name}Address_${object.id}" method="post" action="${g.createLink(action:"individualAddress")}">

<dt class="required">${message(code:'homeFolder.individual.property.address')}</dt>
<dd class="required">
  <label>${message(code:'address.property.additionalDeliveryInformation')}</label>
  <input type="text" name="additionalDeliveryInformation" value="${object.address.additionalDeliveryInformation}" maxlength="38" class="validate-addressLine38" />
      
  <label>${message(code:'address.property.additionalGeographicalInformation')}</label>
  <input type="text" name="additionalGeographicalInformation" value="${object.address.additionalGeographicalInformation}" maxlength="38" class="validate-addressLine38" />

  <label>Numéro et <strong>${message(code:'address.property.streetName')} * </strong></label>
  <input type="text" name="streetNumber" value="${object.address.streetNumber}" maxlength="5" class="line1 validate-streetNumber" />
  <input type="text" name="streetName" value="${object.address.streetName}" maxlength="32" class="line2 validate-streetName" />

  <label>${message(code:'address.property.placeNameOrService')}</label>
  <input type="text" name="placeNameOrService" value="${object.address.placeNameOrService}" maxlength="38" class="validate-addressLine38" />

  <label><strong>${message(code:'address.property.postalCode')} * - ${message(code:'address.property.city')} * </strong></label>
  <input type="text" name="postalCode" value="${object.address.postalCode}" maxlength="5" class="line1 validate-postalCode" />
  <input type="text" name="city" value="${object.address.city}" maxlength="32" size="4" class="line2 validate-city" />

  <label>${message(code:'address.property.countryName')}</label>
  <input type="text" name="countryName"  maxlength="38"  class="validate-addressLine38"
    value="${object.address.countryName}" />

  <!-- TODO : wire address referential -->
  <input type="hidden" name="streetMatriculation" value="${object.address.streetMatriculation}" />
  <input type="hidden" name="streetRivoliCode" value="${object.address.streetRivoliCode}" />
  <input type="hidden" name="cityInseeCode" value="${object.address.cityInseeCode}" />
</dd>
<g:render template="edit/submit" model="['object': object, 'template': name + 'Address']" />
</form>