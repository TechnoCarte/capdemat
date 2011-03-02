<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <script type="text/javascript" src="${resource(dir:'js/frontoffice', file:'homeFolder.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <g:if test="${child.id != null}">
          ${child.born ? child.fullName : message(code:'request.subject.childNoBorn', args:[child.fullName])}
        </g:if>
        <g:else>
          ${message(code:'homeFolder.header.createChild')}
        </g:else>
      </h2>
      <div class="datas collection summary-box">
        <div class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : ''} form">
          <g:if test="${child.id != null}">
            <h3 id="generalInformations">${message(code:'homeFolder.individual.header.general')}</h3>
            <g:render template="${child.fragmentMode('general')}" />
            <h3 id="identity">${message(code:'homeFolder.individual.header.identity')}</h3>
            <g:render template="${child.fragmentMode('identity')}" />
            <h3 id="responsibles">${message(code:'homeFolder.property.legalResponsibles')}</h3>
            <g:render template="${child.fragmentMode('responsibles')}" />
          </g:if>
          <g:else>
            <form action="${createLink(controller : 'frontofficeHomeFolder', action:'child')}" method="post">
              <g:render template="edit/childCommonFields" />
              <input type="submit" value="${message(code:'action.create')}" />
            </form>
          </g:else>
          </div>
        </div>
        <div class="steps">
          <ul>
            <g:if test="${child.id != null}">
              <li class="anchor">
                <a href="#generalInformations">${message(code:'homeFolder.individual.header.general')}</a>
                <a href="#identity">${message(code:'homeFolder.individual.header.identity')}</a>
                <a href="#responsibles">${message(code:'homeFolder.property.legalResponsibles')}</a>
              </li>
            </g:if>
            <li class="back">
              <a href="${createLink(action:'index')}">${message(code:'homeFolder.action.back')}</a>
            </li>
          </ul>
        </div>
    </div>
  </body>
</html>
