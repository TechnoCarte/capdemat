<form id="childIdentity_${child.id}" method="post" action="${g.createLink(action:'editChild')}">

    <label for="lastName" class="required">${message(code:'homeFolder.individual.property.lastName')} *</label>
    <input type="text" name="lastName" value="${child.lastName}" 
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}" 
      title="<g:message code="homeFolder.individual.property.lastName.validationError"/>" />

    <label for="firstName" class="required">${message(code:'homeFolder.individual.property.firstName')} *</label>
    <input type="text" name="firstName" value="${child.firstName}" 
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}" 
      title="<g:message code="homeFolder.individual.property.firstName.validationError"/>"/>

    <label for="firstName2">${message(code:'homeFolder.individual.property.firstName2')}</label>
    <input type="text" name="firstName2" value="${child.firstName2}" />

    <label for="firstName3">${message(code:'homeFolder.individual.property.firstName3')}</label>
    <input type="text" name="firstName3" value="${child.firstName3}" />

    <label class="required">${message(code:'homeFolder.individual.property.birthDate')} *</label>
      <script type="text/javascript">
        var zcf = zenexity.capdemat.fong;
        zcf.i18n = {};
        zcf.i18n['child.expectedBirthDate'] = '<g:message code="homeFolder.individual.property.expectedBirthDate" />';
        zcf.i18n['child.birthDate'] = '<g:message code="homeFolder.individual.property.birthDate" />';
      </script>
      <div class="date required validate-date">
        <select id="birthDate_day" name="birthDate_day" class="day ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${1..31}">
            <option value="${it}"
              <g:if test="${child?.birthDate?.date == it
                || (child?.birthDate == null && params['birthDate_day'] == it.toString())}">
                selected="selected"
              </g:if>>
              ${it}
            </option>
          </g:each>
        </select>
        <select id="birthDate_month" name="birthDate_month" class="month ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each in="${1..12}">
            <option value="${it}"
              <g:if test="${child?.birthDate?.month == (it - 1)
                || (child?.birthDate == null && params['birthDate_month'] == it.toString())}">
                selected="selected"
              </g:if>>
              <g:message code="month.${it}" />
            </option>
          </g:each>
        </select>
        <input type="text" id="birthDate_year" name="birthDate_year" maxlength="4" size="3"
          class="year ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}"
          value="${child?.birthDate ? child?.birthDate.year + 1900 : params['birthDate_year']}" />
      </div>

    <label for="birthPostalCode">${message(code:'homeFolder.individual.property.birthPostalCode')}</label>
    <input type="text" name="birthPostalCode" value="${child.birthPostalCode}" />

    <label for="birthCity">${message(code:'homeFolder.individual.property.birthCity')}</label>
    <input type="text" name="birthCity" value="${child.birthCity}" />

    <label for="birthCountry">${message(code:'homeFolder.individual.property.birthCountry')}</label>
    <input type="text" name="birthCountry" value="${child.birthCountry}" />

    <g:render template="edit/submit" model="['object':child, 'mode':mode]" />
</form>