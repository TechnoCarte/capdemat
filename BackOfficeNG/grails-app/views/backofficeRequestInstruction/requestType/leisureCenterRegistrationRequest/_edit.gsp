


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="lcrr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="lcrr.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="lcrr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="lcrr.property.centresLoisirs.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="lcrr.property.idCentreLoisirs.label" /> * : </dt><dd id="idCentreLoisirs" class="action-editField validate-string required-true i18n-lcrr.property.idCentreLoisirs" ><span>${rqt?.idCentreLoisirs}</span></dd>
                
                  <dt class="required"><g:message code="lcrr.property.labelCentreLoisirs.label" /> * : </dt><dd id="labelCentreLoisirs" class="action-editField validate-string required-true i18n-lcrr.property.labelCentreLoisirs" ><span>${rqt?.labelCentreLoisirs}</span></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcrr.property.modeAccueil.label" /> * : </dt><dd id="modeAccueil" class="action-editField validate-localReferentialData required-true i18n-lcrr.property.modeAccueil data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'modeAccueil', 'lrEntries': lrTypes.modeAccueil?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.modeAccueil?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-estDerogation-trigger"><g:message code="lcrr.property.estDerogation.label" /> * : </dt><dd id="estDerogation" class="action-editField validate-boolean required-true i18n-lcrr.property.estDerogation" ><span class="value-${rqt?.estDerogation}"><g:message code="message.${rqt?.estDerogation ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-filled"><g:message code="lcrr.property.motifsDerogation.label" /> * : </dt><dd id="motifsDerogation" class="action-editField validate-localReferentialData required-true i18n-lcrr.property.motifsDerogation data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'motifsDerogation', 'lrEntries': lrTypes.motifsDerogation?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.motifsDerogation?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="lcrr.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="lcrr.property.acceptationReglementInterieur.label" /> * : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance required-true i18n-lcrr.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
      
    
    
  </div>
  
</div>
