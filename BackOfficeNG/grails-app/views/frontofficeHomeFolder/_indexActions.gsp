<% 
  def className = individual.class.simpleName.toLowerCase()
%>
<g:if test="${individual.id != flash.idToDelete}">
  <dd class="action">
    <a href="${createLink(action:className, params:['id':individual.id])}">${message(code:'homeFolder.individual.action.seeDetails')}</a>
    <g:if test="${!individual.homeFolderResponsible()}">
      / <a href="${createLink(action:'index', params:['idToDelete':individual.id])}">${message(code:'action.remove')}</a>
    </g:if>
  </dd>
</g:if>
<g:else>
  <dd class="action delete">
    <a href="${createLink(action:index)}">${message(code:'action.cancel')}</a>
    <g:if test="${!individual.homeFolderResponsible()}">
      / 
      <a href="${createLink(action:'deleteIndividual', params:['id':individual.id])}" ${individual.id == flash.idToDelete ? 'class="delete"' : ''}>
        ${message(code:'action.remove')}
      </a>
    </g:if>
  </dd>
</g:else>
