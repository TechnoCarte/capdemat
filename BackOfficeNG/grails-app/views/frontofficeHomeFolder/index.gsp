<html>
  <head>
    <title>${message(code:'homeFolder.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <g:if test="${flash.successMessage}"><div class="success-box"><p>${flash.successMessage}</p></div></g:if>
    <div class="main-box">
      <h2>${message(code:'homeFolder.header.generalInformations')}</h2>
      <div class="yui-g homeFolder-action">
        <div class="yui-u first">
          <p>${message(code:'property.state')} : ${g.capdematEnumToFlag(var:homeFolder.state, i18nKeyPrefix:'user.state')}</p>
          <p>${message(code:'property.address')} : 
            <strong>
              ${homeFolder.address.streetNumber} ${homeFolder.address.streetName}
              ${homeFolder.address.postalCode} ${homeFolder.address.city}
            </strong>
          </p>
        </div>
        <div class="yui-u">
          <p><a href="${createLink(action:'editPassword')}">${message(code:'account.action.editPassword')}</a></p>
          <p><a href="${createLink(action:'editQuestion')}">${message(code:'account.action.editQuestion')}</a></p>
        </div>
      </div>
    </div>
    <div class="yui-g individual">
      <!-- Adults -->
      <div class="yui-u first">
        <h2>
          <a href="${createLink(action:'adult')}" class="action">${message(code:'homeFolder.action.addAdult')}</a>
          ${message(code:'homeFolder.property.adults')}
        </h2>
        <g:if test="${!adults.isEmpty()}">
          <g:each var="adult" in="${adults}">
            <dl ${adult.id == flash.idToDelete ? 'class="delete"' : ''}>
              <dt>${g.capdematEnumToFlag(var:adult.title, i18nKeyPrefix:'homeFolder.adult.title')} ${adult.fullName}</dt>
              <g:if test="${adult.homeFolderResponsible()}">
                <dd>${g.capdematEnumToFlag(var:adult.homeFolderResponsible(), i18nKeyPrefix:'homeFolder.role')}</dd>
              </g:if>
              <g:if test="${adult.homePhone}">
                <dd>${message(code:'homeFolder.adult.property.homePhone')} : ${adult.homePhone}</dd>
              </g:if>
              <g:if test="${adult.mobilePhone}">
                <dd>${message(code:'homeFolder.adult.property.mobilePhone')} : ${adult.mobilePhone}</dd>
              </g:if>
              <g:if test="${adult.email}">
                <dd>${adult.email}</dd>
              </g:if>
              <g:render template="indexActions" model="['individual': adult]" />
            </dl>
          </g:each>
        </g:if>
      </div>
      <!-- Children -->
      <div class="yui-u">
        <h2>
          <a href="${createLink(action:'child')}" class="action">${message(code:'homeFolder.action.addChild')}</a>
          ${message(code:'homeFolder.property.children')}
        </h2>
        <g:if test="${!children.isEmpty()}">
          <g:each var="child" in="${children}">
            <dl ${child.id == flash.idToDelete ? 'class="delete"' : ''}>
              <dt>
                <g:if test="${child.born}">${child.fullName}</g:if>
                <g:else>${message(code:'request.subject.childNoBorn', args:[child.fullName])}q</g:else>
              <dd>
                <g:if test="${child.born}">${message(code:'homeFolder.header.born')}</g:if>
                <g:else>${message(code:'homeFolder.header.noBorn')}</g:else>
                <g:if test="${child.birthDate}">
                  ${message(code:'homeFolder.header.on')}
                  ${formatDate(date:child.birthDate,formatName:'format.date')}
                </g:if>
              </dd>
              <g:if test="${childResponsibles[child.id] != null}">
                <dd>
                  ${message(code:'homeFolder.child.property.legalResponsibles')} :
                  <ul>
                    <g:each var="roleOwner" in="${childResponsibles[child.id]}">
                      <li>
                        ${roleOwner.fullName}
                        <g:each in="${roleOwner.getIndividualRoles(child.id)}">
                          ${g.capdematEnumToFlag(var:it.role, i18nKeyPrefix:'homeFolder.role')}
                        </g:each>
                      </li>
                    </g:each>
                  </ul>
                </dd>
              </g:if>
              <g:render template="indexActions" model="['individual': child]" />
            </dl> 
          </g:each>
        </g:if>
      </div>
    </div>
  </body>
</html>

