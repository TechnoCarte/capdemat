


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="strr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="strr.step.autorisations.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="strr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="strr.property.ligne.label" /> * : </dt><dd id="ligne" class="action-editField validate-localReferentialData required-true i18n-strr.property.ligne data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'ligne', 'lrEntries': lrTypes.ligne?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.ligne?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="strr.property.arret.label" /> * : </dt><dd id="arret" class="action-editField validate-localReferentialData required-true i18n-strr.property.arret data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'arret', 'lrEntries': lrTypes.arret?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.arret?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="strr.step.autorisations.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-autoriseTiers-trigger condition-autoriseFrereOuSoeur-trigger"><g:message code="strr.property.autorisation.label" /> * : </dt><dd id="autorisation" class="action-editField validate-capdematEnum required-true i18n-strr.property.autorisation javatype-fr.cg95.cvq.business.request.school.AutorisationType" ><g:capdematEnumToField var="${rqt?.autorisation}" i18nKeyPrefix="strr.property.autorisation" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-tiersAutorises" class="required condition-autoriseTiers-filled">
                <g:render template="/backofficeRequestInstruction/requestType/schoolTransportRegistrationRequest/tiersAutorises" model="['rqt':rqt]" />
              </div>
              
            
              
              <h3><g:message code="strr.property.frereOuSoeurAutorise.label" /></h3>
              <dl class="required condition-autoriseFrereOuSoeur-filled">
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurNom.label" /> * : </dt><dd id="frereOuSoeurNom" class="action-editField validate-lastName required-true i18n-strr.property.frereOuSoeurNom maxLength-38" ><span>${rqt?.frereOuSoeurNom}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurPrenom.label" /> * : </dt><dd id="frereOuSoeurPrenom" class="action-editField validate-firstName required-true i18n-strr.property.frereOuSoeurPrenom maxLength-38" ><span>${rqt?.frereOuSoeurPrenom}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurEcole.label" /> * : </dt><dd id="frereOuSoeurEcole" class="action-editField validate-string required-true i18n-strr.property.frereOuSoeurEcole" ><span>${rqt?.frereOuSoeurEcole}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurClasse.label" /> * : </dt><dd id="frereOuSoeurClasse" class="action-editField validate-string required-true i18n-strr.property.frereOuSoeurClasse" ><span>${rqt?.frereOuSoeurClasse}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
