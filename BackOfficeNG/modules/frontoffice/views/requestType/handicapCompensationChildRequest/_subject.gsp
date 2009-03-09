




  
    <fieldset class="required">
    <legend><g:message code="hccr.property.hccrSubject.label" /></legend> 
      
    <label class="required"><g:message code="request.property.subjectName" /> *</label>
    <select name="subjectId" class="required validate-not-first" title="<g:message code="request.subject.validationError" /> ">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${subjects}">
        <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
      </g:each>
    </select>
      
    
      <label class="required"><g:message code="hccr.property.subjectBirthDate.label" /> * <span><g:message code="hccr.property.subjectBirthDate.help" /></span></label>
      
            <input type="text" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required condition-isLessThan18-trigger validate-date" title="<g:message code="hccr.property.subjectBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="hccr.property.subjectBirthCity.label" /> * <span><g:message code="hccr.property.subjectBirthCity.help" /></span></label>
      
            <input type="text" name="subjectBirthCity" value="${rqt.subjectBirthCity}" 
                    class="required validate-city" title="<g:message code="hccr.property.subjectBirthCity.validationError" />"  maxLength="32"/>
            
    
      <label class="required"><g:message code="hccr.property.subjectBirthCountry.label" /> * <span><g:message code="hccr.property.subjectBirthCountry.help" /></span></label>
      
            <input type="text" name="subjectBirthCountry" value="${rqt.subjectBirthCountry}" 
                    class="required " title="<g:message code="hccr.property.subjectBirthCountry.validationError" />"  maxLength="50"/>
            
    
      <label class="required condition-isLessThan18-filled"><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /> * <span><g:message code="hccr.property.subjectParentalAuthorityHolder.help" /></span></label>
      
            <select name="subjectParentalAuthorityHolder" class="required condition-isLessThan18-filled validate-not-first" title="<g:message code="hccr.property.subjectParentalAuthorityHolder.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Father','Mother','Other']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType_${it}" ${it == rqt.subjectParentalAuthorityHolder?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" /></option>
              </g:each>
            </select>
            
    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.father.label" /></legend> 
      
    
      <label class=""><g:message code="hccr.property.fatherLastName.label" />  <span><g:message code="hccr.property.fatherLastName.help" /></span></label>
      
            <input type="text" name="fatherLastName" value="${rqt.fatherLastName}" 
                    class=" validate-lastName" title="<g:message code="hccr.property.fatherLastName.validationError" />"  maxLength="38"/>
            
    
      <label class=""><g:message code="hccr.property.fatherFirstName.label" />  <span><g:message code="hccr.property.fatherFirstName.help" /></span></label>
      
            <input type="text" name="fatherFirstName" value="${rqt.fatherFirstName}" 
                    class=" validate-firstName" title="<g:message code="hccr.property.fatherFirstName.validationError" />"  maxLength="38"/>
            
    
      <label class=""><g:message code="hccr.property.fatherJob.label" />  <span><g:message code="hccr.property.fatherJob.help" /></span></label>
      
            <input type="text" name="fatherJob" value="${rqt.fatherJob}" 
                    class=" " title="<g:message code="hccr.property.fatherJob.validationError" />"  maxLength="60"/>
            
    
      <label class=""><g:message code="hccr.property.fatherActivityReduction.label" />  <span><g:message code="hccr.property.fatherActivityReduction.help" /></span></label>
      
            <ul class="">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isFatherActivityReduction-trigger validate-boolean" title="" value="${it}" name="fatherActivityReduction" ${it == rqt.fatherActivityReduction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="condition-isFatherActivityReduction-filled"><g:message code="hccr.property.fatherActivityReductionRatio.label" />  <span><g:message code="hccr.property.fatherActivityReductionRatio.help" /></span></label>
      
            <input type="text" name="fatherActivityReductionRatio" value="${rqt.fatherActivityReductionRatio}" 
                    class="condition-isFatherActivityReduction-filled validate-positiveInteger" title="<g:message code="hccr.property.fatherActivityReductionRatio.validationError" />"  />
            
    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.mother.label" /></legend> 
      
    
      <label class=""><g:message code="hccr.property.motherLastName.label" />  <span><g:message code="hccr.property.motherLastName.help" /></span></label>
      
            <input type="text" name="motherLastName" value="${rqt.motherLastName}" 
                    class=" validate-lastName" title="<g:message code="hccr.property.motherLastName.validationError" />"  maxLength="38"/>
            
    
      <label class=""><g:message code="hccr.property.motherFirstName.label" />  <span><g:message code="hccr.property.motherFirstName.help" /></span></label>
      
            <input type="text" name="motherFirstName" value="${rqt.motherFirstName}" 
                    class=" validate-firstName" title="<g:message code="hccr.property.motherFirstName.validationError" />"  maxLength="38"/>
            
    
      <label class=""><g:message code="hccr.property.motherJob.label" />  <span><g:message code="hccr.property.motherJob.help" /></span></label>
      
            <input type="text" name="motherJob" value="${rqt.motherJob}" 
                    class=" " title="<g:message code="hccr.property.motherJob.validationError" />"  maxLength="60"/>
            
    
      <label class=""><g:message code="hccr.property.motherActivityReduction.label" />  <span><g:message code="hccr.property.motherActivityReduction.help" /></span></label>
      
            <ul class="">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="condition-isMotherActivityReduction-trigger validate-boolean" title="" value="${it}" name="motherActivityReduction" ${it == rqt.motherActivityReduction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="condition-isMotherActivityReduction-filled"><g:message code="hccr.property.motherActivityReductionRatio.label" />  <span><g:message code="hccr.property.motherActivityReductionRatio.help" /></span></label>
      
            <input type="text" name="motherActivityReductionRatio" value="${rqt.motherActivityReductionRatio}" 
                    class="condition-isMotherActivityReduction-filled validate-positiveInteger" title="<g:message code="hccr.property.motherActivityReductionRatio.validationError" />"  />
            
    
    </fieldset>
  

  
    <fieldset class="required condition-isLessThan18-filled">
    <legend><g:message code="hccr.property.aseReferent.label" /></legend> 
      
    
      <label class=""><g:message code="hccr.property.aseReferentLastName.label" />  <span><g:message code="hccr.property.aseReferentLastName.help" /></span></label>
      
            <input type="text" name="aseReferentLastName" value="${rqt.aseReferentLastName}" 
                    class=" validate-lastName" title="<g:message code="hccr.property.aseReferentLastName.validationError" />"  maxLength="38"/>
            
    
      <label class=""><g:message code="hccr.property.aseReferentDepartment.label" />  <span><g:message code="hccr.property.aseReferentDepartment.help" /></span></label>
      
            <input type="text" name="aseReferentDepartment" value="${rqt.aseReferentDepartment}" 
                    class=" validate-departmentCode" title="<g:message code="hccr.property.aseReferentDepartment.validationError" />"  maxLength="2"/>
            
    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.referent.label" /></legend> 
      
    
      <label class="required"><g:message code="hccr.property.referentLastName.label" /> * <span><g:message code="hccr.property.referentLastName.help" /></span></label>
      
            <input type="text" name="referentLastName" value="${rqt.referentLastName}" 
                    class="required validate-lastName" title="<g:message code="hccr.property.referentLastName.validationError" />"  maxLength="38"/>
            
    
      <label class="required"><g:message code="hccr.property.referentFirstName.label" /> * <span><g:message code="hccr.property.referentFirstName.help" /></span></label>
      
            <input type="text" name="referentFirstName" value="${rqt.referentFirstName}" 
                    class="required validate-firstName" title="<g:message code="hccr.property.referentFirstName.validationError" />"  maxLength="38"/>
            
    
      <label class="required"><g:message code="hccr.property.referentTitle.label" /> * <span><g:message code="hccr.property.referentTitle.help" /></span></label>
      
            <select name="referentTitle" class="required condition-isReferentMadam-trigger validate-not-first" title="<g:message code="hccr.property.referentTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.referentTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.referentTitle" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isReferentMadam-filled"><g:message code="hccr.property.referentMaidenName.label" /> * <span><g:message code="hccr.property.referentMaidenName.help" /></span></label>
      
            <input type="text" name="referentMaidenName" value="${rqt.referentMaidenName}" 
                    class="required condition-isReferentMadam-filled validate-lastName" title="<g:message code="hccr.property.referentMaidenName.validationError" />"  maxLength="38"/>
            
    
      <label class="required"><g:message code="hccr.property.referentBirthDate.label" /> * <span><g:message code="hccr.property.referentBirthDate.help" /></span></label>
      
            <input type="text" name="referentBirthDate" value="${formatDate(formatName:'format.date',date:rqt.referentBirthDate)}" 
                   class="required validate-date" title="<g:message code="hccr.property.referentBirthDate.validationError" />" />
            
    
      <label class="required"><g:message code="hccr.property.referentBirthCity.label" /> * <span><g:message code="hccr.property.referentBirthCity.help" /></span></label>
      
            <input type="text" name="referentBirthCity" value="${rqt.referentBirthCity}" 
                    class="required validate-city" title="<g:message code="hccr.property.referentBirthCity.validationError" />"  maxLength="32"/>
            
    
      <label class="required"><g:message code="hccr.property.referentBirthCountry.label" /> * <span><g:message code="hccr.property.referentBirthCountry.help" /></span></label>
      
            <input type="text" name="referentBirthCountry" value="${rqt.referentBirthCountry}" 
                    class="required " title="<g:message code="hccr.property.referentBirthCountry.validationError" />"  maxLength="50"/>
            
    
      <label class="required"><g:message code="hccr.property.referentFamilyStatus.label" /> * <span><g:message code="hccr.property.referentFamilyStatus.help" /></span></label>
      
            <select name="referentFamilyStatus" class="required validate-not-first" title="<g:message code="hccr.property.referentFamilyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.referentFamilyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.referentFamilyStatus" /></option>
              </g:each>
            </select>
            
    
      <label class="required"><g:message code="hccr.property.referentFamilyDependents.label" /> * <span><g:message code="hccr.property.referentFamilyDependents.help" /></span></label>
      
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isReferentFamilyDependents-trigger validate-boolean" title="" value="${it}" name="referentFamilyDependents" ${it == rqt.referentFamilyDependents ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
    
    </fieldset>
  

  
    <label class="required condition-isReferentFamilyDependents-filled"><g:message code="hccr.property.familyDependents.label" /> <span><g:message code="hccr.property.familyDependents.help" /></span></label>
    <div class="collection-fieldset required condition-isReferentFamilyDependents-filled validation-scope">
      <!--<h4><g:message code="hccr.property.familyDependents.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'familyDependents' ? editList?.index : ( rqt.familyDependents ? rqt.familyDependents.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required condition-isReferentFamilyDependents-filled">
    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentLastName.label" /> * <span><g:message code="hccr.property.referentFamilyDependentLastName.help" /></span></label>
        
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentLastName" value="${editList?.familyDependents?.referentFamilyDependentLastName}" 
                    class="required validate-lastName" title="<g:message code="hccr.property.referentFamilyDependentLastName.validationError" />"  maxLength="38"/>
            
    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentFirstName.label" /> * <span><g:message code="hccr.property.referentFamilyDependentFirstName.help" /></span></label>
        
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentFirstName" value="${editList?.familyDependents?.referentFamilyDependentFirstName}" 
                    class="required validate-firstName" title="<g:message code="hccr.property.referentFamilyDependentFirstName.validationError" />"  maxLength="38"/>
            
    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /> * <span><g:message code="hccr.property.referentFamilyDependentBirthDate.help" /></span></label>
        
            <input type="text" name="familyDependents[${listIndex}].referentFamilyDependentBirthDate" value="${formatDate(formatName:'format.date',date:editList?.familyDependents?.referentFamilyDependentBirthDate)}" 
                   class="required validate-date" title="<g:message code="hccr.property.referentFamilyDependentBirthDate.validationError" />" />
            
    
        <label class="required"><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /> * <span><g:message code="hccr.property.referentFamilyDependentActualSituation.help" /></span></label>
        
            <select name="familyDependents[${listIndex}].referentFamilyDependentActualSituation" class="required validate-not-first" title="<g:message code="hccr.property.referentFamilyDependentActualSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Schooling','Learning','MedicoSocial']}">
                <option value="fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType_${it}" ${it == editList?.familyDependents?.referentFamilyDependentActualSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" /></option>
              </g:each>
            </select>
            
    
        <g:if test="${editList?.name == 'familyDependents'}">
          <input type="submit" id="submit-collectionModify-subject-familyDependents[${listIndex}]" name="submit-collectionModify-subject-familyDependents[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-subject-familyDependents[${listIndex}]" name="submit-collectionAdd-subject-familyDependents[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.familyDependents}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="hccr.property.familyDependents.label" /></legend> -->
        <dl>
    
        <dt><g:message code="hccr.property.referentFamilyDependentLastName.label" /></dt>
        <dd>${it.referentFamilyDependentLastName}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentFirstName.label" /></dt>
        <dd>${it.referentFamilyDependentFirstName}</dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.referentFamilyDependentBirthDate}"/></dd>
    
        <dt><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /></dt>
        
              <dd>
                <g:if test="${it.referentFamilyDependentActualSituation}">
                  <g:capdematEnumToField var="${it.referentFamilyDependentActualSituation}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" />
                </g:if>
              </dd>
              
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-subject-familyDependents[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-subject-familyDependents[${index}]" />
      </fieldset>
    </g:each>
    </div>
  
