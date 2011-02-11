<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request a.back-account { color: #E6648D !important; }
    </style>
  </head>
  <body>
    <div id="request" class="main-box">
      <g:if test="${!child.born}">
        <h2><g:message code="request.subject.childNoBorn" args="${[child.fullName]}" /></h2>
      </g:if>
      <g:else>
        <h2>${child.firstName} ${child.lastName}</h2>
      </g:else>

      <div class="datas collection summary-box">
        <div class="form">
          <h3 id="generalInformations"><g:message code="homeFolder.individual.header.general" /></h3>
            <dl>
              <dt><g:message code="property.creationDate" /> : </dt>
              <dd><g:formatDate formatName="format.date" date="${child.creationDate}"/></dd>
              <dt><g:message code="property.state" /> : </dt>
              <dd><g:capdematEnumToFlag var="${child.state}" i18nKeyPrefix="actor.state" /></dd>
            </dl>
  
          <h3 id="identity">
              <g:message code="homeFolder.individual.header.identity" />
              <g:if test="${mode != 'editIdentity'}">
                <span><a href="${createLink(action:'child', params:['id':child.id, 'mode':'editIdentity'])}#identity">
                  <g:message code="action.modify" /></a></span>
              </g:if>
          </h3>
            <g:if test="${mode == 'editIdentity'}">
                <g:render template="edit/childIdentity" />
            </g:if>
            <g:else>
                <g:render template="static/childIdentity" />
            </g:else>
  
          <h3 id="legalResponsibles">
              <g:message code="homeFolder.property.legalResponsibles" />
              <g:if test="${mode != 'editResponsibles'}">
                <span><a href="${createLink(action:'child', params:['id':child.id, 'mode':'editResponsibles'])}#legalResponsibles">
                    <g:message code="action.modify" /></a></span>
              </g:if>
          </h3>
            <g:if test="${mode == 'editResponsibles'}">
                <g:render template="edit/childResponsibles" />
            </g:if>
            <g:else>
                <g:render template="static/childResponsibles" />
            </g:else>
          </div>
        </div>

        <div class="steps">
          <ul>
            <li>
                <a href="#generalInformations"><g:message code="homeFolder.individual.header.general" /></a>
                <a href="#identity"><g:message code="homeFolder.individual.header.identity" /></a>
                <a href="#legalResponsibles"><g:message code="homeFolder.property.legalResponsibles" /></a>
                <br />
                <a href="${createLink(action:'index')}" class="back-account">Retour au compte</a>
            </li>
          </ul>
        </div>
    </div>
  </body>
</html>
