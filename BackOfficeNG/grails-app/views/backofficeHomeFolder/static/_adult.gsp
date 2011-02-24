<div id="adult_${adult.id}" class="account collapse">
  <a class="toggle">${message(code:'action.expand')} / ${message(code:'action.collapse')}</a>
  <dl class="edit state collapse">
    <g:render template="static/state" model="['actor':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.identity')}</h3>
  <dl class="edit identity collapse">
    <g:render template="static/adultIdentity" model="['individual':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.address')}</h3>
  <dl class="edit address collapse">
    <g:render template="static/adultAddress" model="['adult':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.contact')}</h3>
  <dl class="edit contact collapse">
    <g:render template="static/adultContact" model="['adult':adult]" />
  </dl>
  <h3>${message(code:'homeFolder.individual.header.auth')}</h3>
  <dl class="collapse">
    <g:render template="static/adultAuth" model="['adult':adult]" />
  </dl>
</div>
