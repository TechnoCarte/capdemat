<a href="${createLink(action:'adult', params:['id':adult.id, 'fragment':'contact'])}#contact">
  ${message(code:'action.modify')}
</a>
<dl>
  <dt>${message(code:'homeFolder.adult.property.email')} : </dt>
  <dd>${adult.email}</dd>
  <dt>${message(code:'homeFolder.adult.property.homePhone')} : </dt>
  <dd>${adult.homePhone}</dd>
  <dt>${message(code:'homeFolder.adult.property.mobilePhone')} : </dt>
  <dd>${adult.mobilePhone}</dd>
  <dt>${message(code:'homeFolder.adult.property.officePhone')} : </dt>
  <dd>${adult.officePhone}</dd>
</dl>
