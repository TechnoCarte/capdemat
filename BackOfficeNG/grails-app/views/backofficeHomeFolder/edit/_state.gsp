<%
  def className = actor.class.simpleName.toLowerCase()
%>
<form id="${className}State_${actor.id}" method="post" action="${g.createLink(action : "individualState")}">
<dt class="required">${message(code:'homeFolder.individual.property.state')}</dt>
<dd class="required">
  <select name="state">
    <g:each var="state" in="${states}">
      <option value="fr.cg95.cvq.business.users.ActorState_${state}" ${state == actor.state ? 'selected="selected"' : ''}>
        ${g.capdematEnumToText(var:state, i18nKeyPrefix:'actor.state')}
      </option>
    </g:each>
  </select>
</dd>
<g:render template="edit/submit" model="['object': actor, 'template': className + 'State']" />
</form>
