


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete'}">
                <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                  <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:if>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:elseif>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                    <span>(<a id="addAdultLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                    <g:message code="message.or" />
                    <a id="addChildLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                  </g:elseif>
                </g:if>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['enfant'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="gsrr.property.estDerogation.label" /> *  <span><g:message code="gsrr.property.estDerogation.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['enfant'].invalidFields.contains('estDerogation') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estDerogation_${it ? 'yes' : 'no'}" class="required condition-estDerogation-trigger  validate-one-required boolean" title="" value="${it}" name="estDerogation" ${it == rqt.estDerogation ? 'checked="checked"': ''} />
                <label for="estDerogation_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-estDerogation-filled"><g:message code="gsrr.property.ecoleDerogation.label" /> *  <span><g:message code="gsrr.property.ecoleDerogation.help" /></span></label>
            <g:set var="ecoleDerogationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'ecoleDerogation', 'i18nPrefixCode':'gsrr.property.ecoleDerogation', 'htmlClass':'required condition-estDerogation-filled  ', 
                              'lrEntries': lrTypes.ecoleDerogation.entries, 'depth':0]" />
            

  

  
    <label class="required condition-estDerogation-filled"><g:message code="gsrr.property.motifsDerogation.label" /> *  <span><g:message code="gsrr.property.motifsDerogation.help" /></span></label>
            <g:set var="motifsDerogationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'motifsDerogation', 'i18nPrefixCode':'gsrr.property.motifsDerogation', 'htmlClass':'required condition-estDerogation-filled condition-estMotifAutre-trigger  ', 
                              'lrEntries': lrTypes.motifsDerogation.entries, 'depth':0]" />
            

  

  
    <label for="motifAutrePrecision" class="required condition-estMotifAutre-filled"><g:message code="gsrr.property.motifAutrePrecision.label" /> *  <span><g:message code="gsrr.property.motifAutrePrecision.help" /></span></label>
            <input type="text" id="motifAutrePrecision" name="motifAutrePrecision" value="${rqt.motifAutrePrecision?.toString()}" 
                    class="required condition-estMotifAutre-filled  validate-string ${rqt.stepStates['enfant'].invalidFields.contains('motifAutrePrecision') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.motifAutrePrecision.validationError" />"   />
            

  

  
    <label for="informationsComplementairesDerogation" class="condition-estDerogation-filled"><g:message code="gsrr.property.informationsComplementairesDerogation.label" />   <span><g:message code="gsrr.property.informationsComplementairesDerogation.help" /></span></label>
            <textarea id="informationsComplementairesDerogation" name="informationsComplementairesDerogation" class="condition-estDerogation-filled  validate-regex ${rqt.stepStates['enfant'].invalidFields.contains('informationsComplementairesDerogation') ? 'validation-failed' : ''}" title="<g:message code="gsrr.property.informationsComplementairesDerogation.validationError" />" rows="10" cols="" regex="^.{0,1024}$" maxlength="1024">${rqt.informationsComplementairesDerogation}</textarea>
            

  

  
    <label class="required condition-estDerogation-unfilled"><g:message code="gsrr.property.ecoleSecteur.label" /> *  <span><g:message code="gsrr.property.ecoleSecteur.help" /></span></label>
            <g:set var="ecoleSecteurIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'ecoleSecteur', 'i18nPrefixCode':'gsrr.property.ecoleSecteur', 'htmlClass':'required condition-estDerogation-unfilled  ', 
                              'lrEntries': lrTypes.ecoleSecteur.entries, 'depth':0]" />
            

  

