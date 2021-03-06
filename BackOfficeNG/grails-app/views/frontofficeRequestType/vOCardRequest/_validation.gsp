<h3><g:message code="vcr.step.adults.label" /></h3>
<g:each var="it" in="${individuals?.adults}" status="index">
  <div class="account-fieldset-edit">
  <h4>
    <g:capdematEnumToField var="${it.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${it.firstName} ${it.lastName}
  </h4> 
  <dl>
    <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
    <dd> <g:capdematEnumToField var="${it.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

    <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
    <dd>
      <div>
        <p class="additionalDeliveryInformation">${it.adress?.additionalDeliveryInformation}</p>
        <p class="additionalGeographicalInformation">${it.adress?.additionalGeographicalInformation}</p>
        <span class="streetNumber">${it.adress?.streetNumber}</span>
        <span class="streetName">${it.adress?.streetName}</span>
        <p class="placeNameOrService">${it.adress?.placeNameOrService}</p>
        <span class="postalCode">${it.adress?.postalCode}</span>
        <span class="city">${it.adress?.city}</span>
        <p class="countryName">${it.adress?.countryName}</p>
      </div>
    </dd>

    <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
    <dd>${it.email}</dd>

    <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
    <dd>${it.homePhone}</dd>

    <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
    <dd>${it.mobilePhone}</dd>

    <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
    <dd>${it.officePhone}</dd>
  </dl>
  </div>
</g:each>

<g:if test="${individuals?.children}">
<h3><g:message code="vcr.step.children.label" /></h3>
<g:each var="it" in="${individuals?.children}" status="index">
  <div class="account-fieldset-edit">
  <g:if test="${!it.isChildBorn}">
    <h4><g:message code="request.subject.childNoBorn"
          args="${[it.fullName]}" /></h4>
  </g:if>
  <g:else>
    <h4>${it.firstName} ${it.lastName}</h4>
  </g:else>
  <dl>
    <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
    <dd><g:capdematEnumToField var="${it.sex}" i18nKeyPrefix="homeFolder.child.property.sex" /></dd>

    <dt>
        <g:if test="${!it.isChildBorn}"><g:message code="homeFolder.individual.property.expectedBirthDate" /></g:if>
        <g:else><g:message code="homeFolder.individual.property.birthDate" /></g:else>
    : </dt>
    <dd><span><g:formatDate formatName="format.date" date="${it.birthDate}"/></span></dd>
  </dl>
  </div>
</g:each>
</g:if>

