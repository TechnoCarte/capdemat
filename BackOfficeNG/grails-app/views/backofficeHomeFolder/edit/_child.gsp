<div id="child_" class="account">
  <h3>${message(code:'homeFolder.individual.header.newChild')}</h3>
  <form id="addChild_" method="post" action="${g.createLink(action:'child')}">
    <dl>
      <dt class="required">${message(code:'homeFolder.individual.property.born')}</dt>
      <dd class="required">
        <ul class="yes-no">
          <g:each in="${[true,false]}">
            <li>
              <input type="radio" value="${it}" name="born" ${it == child?.born ? 'checked="checked"': ''} />
              <label for="born_${it ? 'yes' : 'no'}">${message(code:'message.' + (it ? 'yes' : 'no'))}</label>
            </li>
          </g:each>
        </ul>
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt> 
      <dd class="required">
        <input type="text" name="lastName" value="${child.lastName}" />
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
      <dd class="required">
        <input type="text" name="firstName" value="${child.firstName}" />
      </dd>
      <dt class="required">${message(code:'homeFolder.child.property.sex')}</dt>
      <dd>
        <select name="sex">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
            <option value="fr.cg95.cvq.business.users.SexType_${it}"
              ${it == child.sex ? 'selected="selected"': ''}>
              ${g.capdematEnumToText(var:it, i18nKeyPrefix:'homeFolder.child.property.sex')}
            </option>
          </g:each>
        </select>
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
      <dd class="required">
        <input type="text" name="birthDate" value="${g.formatDate(formatName:'format.date', date: child.birthDate)}" />
      </dd>
    </dl>
    <h3>${message(code:'homeFolder.property.legalResponsibles')}</h3>
    <dl>
      <dt class="required">${responsible.fullName}</dt>
      <dd class="required">
        <select name="roleType" style="width : auto; display : inline;" class="${invalidFields?.contains('legalResponsibles') ? 'validation-failed' : ''}">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
            <option value="${roleType}">
              ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
            </option>
          </g:each>
        </select>
      </dd>
    </dl>
    <dl style="margin-top:1em">
      <g:render template="edit/submit" model="['object':child]" />
    </dl>
  </form>
</div>
