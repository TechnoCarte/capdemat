<dt>&nbsp;</dt>
<dd style="font-size: .9em;">
  <input type="hidden" name="template" value="${template}" />
  <input type="hidden" name="id" value="${object.id}" />
  <input type="submit" name="cancel" value="${message(code:'action.cancel')}" class="cancel${!object.id ? 'Add' : ''}" />
  <input type="submit" name="submit" value="${message(code:'action.save')}" class="save" />
</dd>
