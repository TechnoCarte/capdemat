<html>
  <head>
    <title>${message(code:'homeFolder.header.details', args:[params.id])}</title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'homeFolderDetails.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'homeFolder.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'document.css')}" />
    <script type="text/javascript">
      zenexity.capdemat.backoffice.homeFolder.Details.homeFolderId = ${params.id};
    </script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'homeFolder.header.details', args:[params.id])}</h1>
        </div>

        <div id="homeFolder" class="mainbox mainbox-yellow">
          <h2>${message(code:'homeFolder.search.isHomeFolderResponsible')}</h2>

          <div id="adult_${homeFolderResponsible.id}" class="account collapse">
            <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
            <div class="yui-g">
              <div class="yui-u first">
                <dl class="edit state collapse">
                  <g:render template="static/adultState" model="['adult':homeFolderResponsible]" />
                </dl>
                <h3>Idendité </h3>
                <dl class="edit identity collapse">
                  <g:render template="static/adultIdentity" model="['adult':homeFolderResponsible]" />
                </dl>
                <h3>Authentification</h3>
                <dl class="collapse">
                  <g:render template="static/adultAuth" model="['adult':homeFolderResponsible]" />
                </dl>
              </div>
              <div class="yui-u">
                <h3>Adresse</h3>
                <dl class="edit address reponsible collapse">
                  <g:render template="static/adultAddress" model="['adult':homeFolderResponsible, 'isResponsible':true]" />
                </dl>
                <h3>Contact</h3>
                <dl class="edit contact reponsible collapse">
                  <g:render template="static/adultContact" model="['adult':homeFolderResponsible, 'isResponsible':true]" />
                </dl>
              </div>
            </div>
          </div>

          <div class="yui-g">
            <div class="yui-u first">
              <h2>${message(code:'homeFolder.property.adults')}</h2>
              <g:each var="record" in="${adults}">
                <div id="adult_${record.id}" class="account collapse">
                  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
                  <dl class="edit state collapse">
                    <g:render template="static/adultState" model="['adult':record]" />
                  </dl>
                  <h3>Idendité </h3>
                  <dl class="edit identity collapse">
                    <g:render template="static/adultIdentity" model="['adult':record]" />
                  </dl>
                  <h3>Adresse</h3>
                  <dl class="edit address collapse">
                    <g:render template="static/adultAddress" model="['adult':record]" />
                  </dl>
                  <h3>Contact</h3>
                  <dl class="edit contact collapse">
                    <g:render template="static/adultContact" model="['adult':record]" />
                  </dl>
                  <h3>Authentification</h3>
                  <dl class="collapse">
                    <g:render template="static/adultAuth" model="['adult':record]" />
                  </dl>
                </div>
              </g:each>
            </div>

            <div class="yui-u">
              <g:if test="${children.isEmpty()}">
                ${message(code:'homeFolder.label.noChild')}
              </g:if>
              <g:else>
                <h2>${message(code:'homeFolder.property.children')}</h2>
                <g:each var="record" in="${children}">
                  <div id="child_${record.id}" class="account collapse">
                    <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
                    <dl class="edit state collapse">
                      <g:render template="static/childState" model="['child':record]" />
                    </dl>
                    <h3>Idendité</h3>
                    <dl class="edit identity collapse">
                      <g:render template="static/childIdentity" model="['child':record]" />
                    </dl>
                    <h3>Responsables</h3>
                    <dl class="edit responsibles collapse">
                      <g:render template="static/childResponsibles" model="['child':record, 'roleOwners': responsibles[record.id]]" />
                    </dl>
                  </div>
                </g:each>
              </g:else>
            </div>
          </div>

        </div>

        <!-- Request TabView -->
        <div id="homeFolderInformation"></div>

      </div>
    </div>
    <div id="narrow" class="yui-b">

      <!-- home folder state -->
      <div class="nobox taskstate">
        <h3>${message(code:'property.homeFolderState')}</h3>
        <div class="body">
          <span id="homeFolderState" class="tag-${homeFolderState}" style="float: right; font-size:1.1em">
            ${message(code:'actor.state.' + homeFolderState)}
          </span>
        </div>
      </div>

      <div class="nobox taskstate">
        <h3>${message(code:'header.subMenus')}</h3>
        <div class="body">
          <p>
            <a href="${createLink(controller: 'frontofficeHome',action:'loginAgent')}/?login=${responsableLogin}" target="_blank">
              ${message(code:'homeFolder.header.goToAccount')}
            </a>
          </p>
        </div>
      </div>

    </div>

  </body>
</html>
