


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="gsrr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="gsrr.step.restauration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="gsrr.step.periscolaire.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="gsrr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-trigger"><g:message code="gsrr.property.estDerogation.label" /> * : </dt><dd id="estDerogation" class="action-editField validate-boolean required-true i18n-gsrr.property.estDerogation" ><span class="value-${rqt?.estDerogation}"><g:message code="message.${rqt?.estDerogation ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-filled"><g:message code="gsrr.property.ecoleDerogation.label" /> * : </dt><dd id="ecoleDerogation" class="action-editField validate-localReferentialData required-true i18n-gsrr.property.ecoleDerogation data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'ecoleDerogation', 'lrEntries': lrTypes.ecoleDerogation?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.ecoleDerogation?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-filled condition-estMotifAutre-trigger"><g:message code="gsrr.property.motifsDerogation.label" /> * : </dt><dd id="motifsDerogation" class="action-editField validate-localReferentialData required-true i18n-gsrr.property.motifsDerogation data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'motifsDerogation', 'lrEntries': lrTypes.motifsDerogation?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.motifsDerogation?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estMotifAutre-filled"><g:message code="gsrr.property.motifAutrePrecision.label" /> * : </dt><dd id="motifAutrePrecision" class="action-editField validate-string required-true i18n-gsrr.property.motifAutrePrecision" ><span>${rqt?.motifAutrePrecision}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-estDerogation-filled"><g:message code="gsrr.property.informationsComplementairesDerogation.label" />  : </dt><dd id="informationsComplementairesDerogation" class="action-editField validate-regex i18n-gsrr.property.informationsComplementairesDerogation rows-10 maxLength-1024" regex="^.{0,1024}$"><span>${rqt?.informationsComplementairesDerogation}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-estDerogation-unfilled"><g:message code="gsrr.property.ecoleSecteur.label" /> * : </dt><dd id="ecoleSecteur" class="action-editField validate-localReferentialData required-true i18n-gsrr.property.ecoleSecteur data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'ecoleSecteur', 'lrEntries': lrTypes.ecoleSecteur?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.ecoleSecteur?.entriesSupportMultiple, 'depth':0]" />
 
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
          <span><g:message code="gsrr.step.restauration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-estRestauration-trigger"><g:message code="gsrr.property.estRestauration.label" /> * : </dt><dd id="estRestauration" class="action-editField validate-boolean required-true i18n-gsrr.property.estRestauration" ><span class="value-${rqt?.estRestauration}"><g:message code="message.${rqt?.estRestauration ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estRestauration-filled"><g:message code="gsrr.property.regimeAlimentaire.label" /> * : </dt><dd id="regimeAlimentaire" class="action-editField validate-localReferentialData required-true i18n-gsrr.property.regimeAlimentaire data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'regimeAlimentaire', 'lrEntries': lrTypes.regimeAlimentaire?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.regimeAlimentaire?.entriesSupportMultiple, 'depth':0]" />
 
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="gsrr.step.periscolaire.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="gsrr.property.estPeriscolaire.label" /> * : </dt><dd id="estPeriscolaire" class="action-editField validate-boolean required-true i18n-gsrr.property.estPeriscolaire" ><span class="value-${rqt?.estPeriscolaire}"><g:message code="message.${rqt?.estPeriscolaire ? 'yes' : 'no'}" /></span></dd>
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
