<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <style type="text/css">
      #request .datas form { padding: 1em 0; }
      #request form div p.error { text-align: left; }
    </style>
  </head>
  <body>
    <div id="request" class="main-box">
      <h2>
        <a href="${createLink(action : 'index')}" class="button">${message(code:'action.cancel')}</a>
        ${message(code:'homeFolder.header.createAdult')}
      </h2>
      <div class="datas">
        <div class="${invalidFields && !invalidFields.isEmpty() ? 'invalid' : 'uncomplete'} form">
        <form action="${createLink(controller : 'frontofficeHomeFolder', action:'adult')}" method="post">
          <g:render template="adultCommonFields" />
          <p style="text-align: center; font-size: 1.3em;">
              <input type="submit" value="${message(code:'action.create')}" />
          </p>
        </form>
        </div>
      </div>
    </div>
  </body>
</html>
