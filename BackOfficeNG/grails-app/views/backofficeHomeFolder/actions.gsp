<ul id="userActions">
  <g:each var="action" in="${actions}">
    <li>
      <dl class="action">
        <dt class="title">
          <span class="tag ${action.type.cssClass}">
            <g:message code="${action.type.i18nKey}" />
          </span>
        </dt>
        <dd class="title">
          <span class="tag tag-statechange">Modifié</span>
        </dd>
        <dd class="title">
          <g:message code="searchResult.actionDate" /> :
          <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
          <g:if test="${action.username}">
            <g:message code="layout.by" />
            <strong>${action.username}</strong>
          </g:if>
        </dd>
      </dl>
    </li>
  </g:each>
</ul>
