<form id="childResponsibles_${child.id}" method="post" action="${g.createLink(action:'child')}">
    <g:set var="roleCount" value="${0}" />
    <ul>
      <g:each var="roleOwner" in="${roleOwners}">
        <g:each var="individualRole" in="${roleOwner.getIndividualRoles(child.id)}">
          <li>
            <input type="hidden" name="roles.${roleCount}.id" value="${individualRole.id}" />
            <select name="roles.${roleCount}.owner" style="width : auto; display : inline;">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="adult" in="${adults}">
                <option value="${adult.id}"
                  <g:if test="${roleOwner.id == adult.id}">selected="selected"</g:if>>
                  <g:if test="${adult.id == currentUser.id}">
                    <g:message code="homeFolder.role.message.YouAre" />
                  </g:if>
                  <g:else>
                    <g:message code="homeFolder.role.message.anotherAdultIs" args="${[adult.fullName]}"/>
                  </g:else>
                </option>
              </g:each>
            </select>
            <select name="roles.${roleCount}.type" style="width : auto; display : inline;">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
                <option value="${roleType}"
                  <g:if test="${individualRole.role.equals(roleType)}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${roleType}" i18nKeyPrefix="homeFolder.role.withParticle" />
                </option>
              </g:each>
            </select>
          </li>
          <g:set var="roleCount" value="${roleCount + 1}" />
        </g:each>
      </g:each>
      <g:if test="${roleCount < 3}">
        <g:each var="i" in="${roleCount..2}">
          <li>
            <select name="roles.${i}.owner" style="width : auto; display : inline;"
              class="${i == 0 && invalidFields?.contains('legalResponsibles') ? 'validation-failed' : ''}">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="adult" in="${adults}">
                <option value="${adult.id}"
                  <g:if test="${params['roles.' + i + '.owner'] == adult.id.toString()}">selected="selected"</g:if>>
                  <g:if test="${adult.id == currentUser.id}">
                    <g:message code="homeFolder.role.message.YouAre" />
                  </g:if>
                  <g:else>
                    <g:message code="homeFolder.role.message.anotherAdultIs" args="${[adult.fullName]}"/>
                  </g:else>
                </option>
              </g:each>
            </select>
            <select name="roles.${i}.type" style="width : auto; display : inline;"
              class="${i == 0 && invalidFields?.contains('legalResponsibles') ? 'validation-failed' : ''}">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
                <option value="${roleType}"
                  <g:if test="${params['roles.' + i + '.type'] == roleType.toString()}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${roleType}" i18nKeyPrefix="homeFolder.role.withParticle" />
                </option>
              </g:each>
            </select>
          </li>
        </g:each>
      </g:if>
    </ul>
    <g:render template="edit/submit" model="['object':child, 'mode':mode]" />
</form>