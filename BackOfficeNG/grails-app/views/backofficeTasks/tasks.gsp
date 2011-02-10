<html>
  <head>
    <title><g:message code="tasks.header" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice', file:'tasks.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice', file:'tasks.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="tasks.header.onRequests" /></h1>
        </div>

          <div class="tasks red">
            <h2>
            <strong class="toggle"><g:message code="tasks.header.late" /> (${taskMap.aboutRequests.late.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'search', params : ['filterBy' : 'qualityFilter=Red'])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutRequests.late.count > 0 ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.late.all}" />
            </ul>
          </div>

          <div class="tasks orange">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.urgent" /> (${taskMap.aboutRequests.urgent.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'search', params : ['filterBy' : 'qualityFilter=Orange'])}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutRequests.late.count == 0 && taskMap.aboutRequests.urgent.count > 0 ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.urgent.all}" />
            </ul>
          </div>

          <div class="tasks green">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.toProcess" /> (${taskMap.aboutRequests.usual.count})</strong>
              <a href="${createLink(controller : 'backofficeRequest', action : 'searchUsuals')}" ><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${(taskMap.aboutRequests.late.count == 0 && taskMap.aboutRequests.urgent.count == 0 && taskMap.aboutRequests.usual.count > 0) ? '' : 'collapse'}">
              <g:render template="requestEntry" var="record" collection="${taskMap.aboutRequests.usual.all}" />
            </ul>
          </div>

        <div class="head" style="margin-top: 2em">
          <h1><g:message code="tasks.header.onIndividuals" /></h1>
        </div>

          <div class="tasks red">
            <h2>
            <strong class="toggle"><g:message code="tasks.header.late" /> (${taskMap.aboutIndividuals.late.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'searchLates')}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutIndividuals.late.count > 0 ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.late.all}" />
            </ul>
          </div>

          <div class="tasks orange">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.urgent" /> (${taskMap.aboutIndividuals.urgent.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'searchUrgents')}"><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${taskMap.aboutIndividuals.late.count == 0 && taskMap.aboutIndividuals.urgent.count > 0 ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.urgent.all}" />
            </ul>
          </div>

          <div class="tasks green">
            <h2>
              <strong class="toggle"><g:message code="tasks.header.toProcess" /> (${taskMap.aboutIndividuals.usual.count})</strong>
              <a href="${createLink(controller : 'backofficeHomeFolder', action : 'searchUsuals')}" ><g:message code="action.seeAll" /></a>
            </h2>
            <ul class="${(taskMap.aboutIndividuals.late.count == 0 && taskMap.aboutIndividuals.urgent.count == 0 && taskMap.aboutIndividuals.usual.count > 0) ? '' : 'collapse'}">
              <g:render template="individualEntry" var="record" collection="${taskMap.aboutIndividuals.usual.all}" />
            </ul>
          </div>

      </div>
    </div>

    <div id="narrow" class="yui-b">
    </div>

  </body>
</html>

