<ul id="userActions">
  <g:each var="action" in="${actions}">
    <li>
      <dl class="action">
        <dt class="title">
          <span class="tag ${action.type.cssClass}">
            <g:message code="${action.type.i18nKey}" />
          </span>
        </dt>
        <g:if test="${action.state}">
          <dd class="title">
            <span class="tag ${action.state.cssClass}">
              <g:message code="${action.state.i18nKey}" />
            </span>
          </dd>
        </g:if>
        <dd class="title">
          <g:message code="searchResult.actionDate" /> :
          <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
          <g:if test="${action.username}">
            <g:message code="layout.by" />
            <strong>${action.username}</strong>
          </g:if>
        </dd>
        <g:each var="data" in="${action.data}">
          <dt>${data.key}</dt>
          <dd>${data.value}</dd>
        </g:each>
      </dl>
    </li>
  </g:each>
</ul>
