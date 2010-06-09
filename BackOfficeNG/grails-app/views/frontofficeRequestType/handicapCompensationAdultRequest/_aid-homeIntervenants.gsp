

  <label class="condition-isHomeIntervenant-filled"><g:message code="hcar.property.homeIntervenants.label" /> <span><g:message code="hcar.property.homeIntervenants.help" /></span></label>
  <div class="collection-fieldset condition-isHomeIntervenant-filled validation-scope summary-box">
    <fieldset class="collection-fieldset-add condition-isHomeIntervenant-filled">
    <g:set var="currentCollectionItem" value="${rqt?.homeIntervenants.size() > collectionIndex ? rqt.homeIntervenants.get(collectionIndex) : null}" />
  
      <label for="homeIntervenants.${collectionIndex}.homeIntervenantKind" class="required"><g:message code="hcar.property.homeIntervenantKind.label" /> *  <span><g:message code="hcar.property.homeIntervenantKind.help" /></span></label>
            <select id="homeIntervenants.${collectionIndex}.homeIntervenantKind" name="homeIntervenants[${collectionIndex}].homeIntervenantKind" class="required condition-isOtherHomeIntervant-trigger  validate-not-first ${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants.homeIntervenantKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.homeIntervenantKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Carer','HomeHelp','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType_${it}" ${it == currentCollectionItem?.homeIntervenantKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.homeIntervenantKind" /></option>
              </g:each>
            </select>
            

  
      <label for="homeIntervenants.${collectionIndex}.homeIntervenantDetails" class="required condition-isOtherHomeIntervant-filled"><g:message code="hcar.property.homeIntervenantDetails.label" /> *  <span><g:message code="hcar.property.homeIntervenantDetails.help" /></span></label>
            <input type="text" id="homeIntervenants.${collectionIndex}.homeIntervenantDetails" name="homeIntervenants[${collectionIndex}].homeIntervenantDetails" value="${currentCollectionItem?.homeIntervenantDetails?.toString()}" 
                    class="required condition-isOtherHomeIntervant-filled   ${rqt.stepStates['aid'].invalidFields.contains('homeIntervenants.homeIntervenantDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.homeIntervenantDetails.validationError" />"  maxlength="60" />
            

  
      <input type="hidden" name="currentCollection" value="${currentCollection}" />
      <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
      <input type="submit" id="submit-step-aid-homeIntervenants" name="submit-step-aid-homeIntervenants[${collectionIndex}]" value="${message(code:'action.save')}" />
      <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'aid'])}">
        ${message(code:'request.action.cancelCollectionItemEdit')}
      </a>  
    </fieldset>
</div>
  
