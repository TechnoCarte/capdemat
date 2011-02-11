<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <style type="text/css">
      #request .datas form { padding: 1em 0; }
      #request form div p.error { text-align: left; }
      #request a.back-account { color: #E6648D !important; }
    </style>
  </head>

  <body>
    <div id="request" class="main-box">
      <h2>${adult.firstName} ${adult.lastName}</h2>

      <div class="datas summary-box">
        <div class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : ''} form">

          <h3 id="general">${message(code:'homeFolder.individual.header.general')}</h3>
            <dl>
              <dt>${message(code:'property.creationDate')} : </dt>
              <dd><g:formatDate formatName="format.date" date="${adult.creationDate}"/></dd>
              <dt>${message(code:'property.state')} : </dt>
              <dd><g:capdematEnumToFlag var="${adult.state}" i18nKeyPrefix="actor.state" /></dd>
              <g:if test="${!ownerRoles.homeFolder.isEmpty()}">
                <dt>${message(code:'homeFolder.adult.property.homeFolderRoles')} : </dt>
                <dd>
                  <g:each var="ownerRole" in="${ownerRoles.homeFolder}">
                    <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
                  </g:each>
                </dd>
              </g:if>
              <g:if test="${!ownerRoles.individual.isEmpty()}">
                <dt>${message(code:'homeFolder.adult.property.individualRoles')} : </dt>
                <dd>
                  <g:each var="ownerRole" in="${ownerRoles.individual}">
                    <p>
                      ${ownerRole.subjectName}
                      <g:capdematEnumToFlag var="${ownerRole.role}" i18nKeyPrefix="homeFolder.role" />
                    </p>
                  </g:each>
                </dd>
              </g:if>
              <g:if test="${!subjectRoles.isEmpty()}">
                <dt>${message(code:'homeFolder.adult.property.subjectRoles')} : </dt>
                <dd>
                  <g:each var="subjectRole" in="${subjectRoles}">
                    <p>
                      ${subjectRole.fullName}
                      <g:each var="role" in="${subjectRole.roles}">
                        <g:capdematEnumToFlag var="${role}" i18nKeyPrefix="homeFolder.role" />
                      </g:each>
                    </p>
                  </g:each>
                </dd>
              </g:if>
            </dl>

          <h3 id="identity">${message(code:'homeFolder.individual.header.identity')}
              <g:if test="${mode != 'editIdentity'}">
                <span>
                  <a href="${createLink(action:'adult', params:['id':adult.id, 'mode':'editIdentity'])}#identity">
                    ${message(code:'action.modify')}
                  </a>
                </span>
              </g:if>
          </h3>
            <g:if test="${mode == 'editIdentity'}">
                <g:render template="edit/adultIdentity" />
            </g:if>
            <g:else>
                <g:render template="static/adultIdentity" />
            </g:else>

          <h3 id="address">${message(code:'homeFolder.individual.header.address')}
              <g:if test="${mode != 'editAddress'}">
                <span>
                  <a href="${createLink(action:'adult', params:['id':adult.id, 'mode':'editAddress'])}#address">
                    ${message(code:'action.modify')}
                  </a>
                </span>
              </g:if>
          </h3>
            <g:if test="${mode == 'editAddress'}">
                <g:render template="edit/adultAddress" />
            </g:if>
            <g:else>
                <g:render template="static/adultAddress" />
            </g:else>

          <h3 id="contact">${message(code:'homeFolder.individual.header.contact')}
              <g:if test="${mode != 'editContact'}">
                <span>
                  <a href="${createLink(action:'adult', params:['id':adult.id, 'mode':'editContact'])}#contact">
                    ${message(code:'action.modify')}
                  </a>
                </span>
              </g:if>
          </h3>
            <g:if test="${mode == 'editContact'}">
                <g:render template="edit/adultContact" />
            </g:if>
            <g:else>
                <g:render template="static/adultContact" />
            </g:else>

          <h3 id="connexion">${message(code:'homeFolder.individual.header.connexion')}</h3>
            <dl>
              <dt>${message(code:'homeFolder.adult.property.login')} : </dt><dd>${adult.login}</dd>
              <dt>${message(code:'homeFolder.adult.property.question')} : </dt><dd>${adult.question}</dd>
              <dt>${message(code:'homeFolder.adult.property.answer')} : </dt><dd>${adult.answer}</dd>
            </dl>

        </div>
      </div>
      <div class="steps">
        <ul>
          <li>
              <a href="#general"><g:message code="homeFolder.individual.header.general" /></a>
              <a href="#identity"><g:message code="homeFolder.individual.header.identity" /></a>
              <a href="#address"><g:message code="homeFolder.individual.header.address" /></a>
              <a href="#contact"><g:message code="homeFolder.individual.header.contact" /></a>
              <a href="#connexion"><g:message code="homeFolder.individual.header.connexion" /></a>
              <br />
              <a href="${createLink(action:'index')}" class="back-account">${message(code:'homeFolder.action.back')}</a>
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>
