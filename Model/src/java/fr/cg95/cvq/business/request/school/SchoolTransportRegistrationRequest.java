
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SchoolTransportRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SchoolTransportRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private SchoolTransportRegistrationRequestData schoolTransportRegistrationRequestData;

    public SchoolTransportRegistrationRequest(RequestData requestData, SchoolTransportRegistrationRequestData schoolTransportRegistrationRequestData) {
        super(requestData);
        this.schoolTransportRegistrationRequestData = schoolTransportRegistrationRequestData;
    }

    public SchoolTransportRegistrationRequest() {
        super();
        this.schoolTransportRegistrationRequestData = new SchoolTransportRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("autorisations", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SchoolTransportRegistrationRequestData getSpecificData() {
        return schoolTransportRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SchoolTransportRegistrationRequestData schoolTransportRegistrationRequestData) {
        this.schoolTransportRegistrationRequestData = schoolTransportRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SchoolTransportRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SchoolTransportRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SchoolTransportRegistrationRequestDocument schoolTransportRegistrationRequestDoc = SchoolTransportRegistrationRequestDocument.Factory.newInstance();
        SchoolTransportRegistrationRequestDocument.SchoolTransportRegistrationRequest schoolTransportRegistrationRequest = schoolTransportRegistrationRequestDoc.addNewSchoolTransportRegistrationRequest();
        super.fillCommonXmlInfo(schoolTransportRegistrationRequest);
        int i = 0;
          FrereOuSoeurInformationsType frereOuSoeurInformationsTypeFrereOuSoeurAutorise = schoolTransportRegistrationRequest.addNewFrereOuSoeurAutorise();
        frereOuSoeurInformationsTypeFrereOuSoeurAutorise.setFrereOuSoeurNom(getFrereOuSoeurNom());
      
        if (getAutorisation() != null)
            schoolTransportRegistrationRequest.setAutorisation(fr.cg95.cvq.xml.request.school.AutorisationType.Enum.forString(getAutorisation().toString()));
      
        frereOuSoeurInformationsTypeFrereOuSoeurAutorise.setFrereOuSoeurEcole(getFrereOuSoeurEcole());
      
        frereOuSoeurInformationsTypeFrereOuSoeurAutorise.setFrereOuSoeurPrenom(getFrereOuSoeurPrenom());
      
        i = 0;
        if (getTiersAutorises() != null) {
            fr.cg95.cvq.xml.request.school.TiersInformationsType[] tiersAutorisesTypeTab = new fr.cg95.cvq.xml.request.school.TiersInformationsType[getTiersAutorises().size()];
            for (TiersInformations object : getTiersAutorises()) {
              tiersAutorisesTypeTab[i++] = object.modelToXml();
            }
            schoolTransportRegistrationRequest.setTiersAutorisesArray(tiersAutorisesTypeTab);
        }
      
        i = 0;
        if (getArret() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] arretTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getArret().size()];
            for (LocalReferentialData object : getArret()) {
              arretTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            schoolTransportRegistrationRequest.setArretArray(arretTypeTab);
        }
      
        i = 0;
        if (getLigne() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] ligneTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getLigne().size()];
            for (LocalReferentialData object : getLigne()) {
              ligneTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            schoolTransportRegistrationRequest.setLigneArray(ligneTypeTab);
        }
      
        frereOuSoeurInformationsTypeFrereOuSoeurAutorise.setFrereOuSoeurClasse(getFrereOuSoeurClasse());
      
        return schoolTransportRegistrationRequestDoc;
    }

    @Override
    public final SchoolTransportRegistrationRequestDocument.SchoolTransportRegistrationRequest modelToXmlRequest() {
        return modelToXml().getSchoolTransportRegistrationRequest();
    }

    public static SchoolTransportRegistrationRequest xmlToModel(SchoolTransportRegistrationRequestDocument schoolTransportRegistrationRequestDoc) {
        SchoolTransportRegistrationRequestDocument.SchoolTransportRegistrationRequest schoolTransportRegistrationRequestXml = schoolTransportRegistrationRequestDoc.getSchoolTransportRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SchoolTransportRegistrationRequest schoolTransportRegistrationRequest = new SchoolTransportRegistrationRequest();
        schoolTransportRegistrationRequest.fillCommonModelInfo(schoolTransportRegistrationRequest, schoolTransportRegistrationRequestXml);
        
        schoolTransportRegistrationRequest.setFrereOuSoeurNom(schoolTransportRegistrationRequestXml.getFrereOuSoeurAutorise().getFrereOuSoeurNom());
      
        if (schoolTransportRegistrationRequestXml.getAutorisation() != null)
            schoolTransportRegistrationRequest.setAutorisation(fr.cg95.cvq.business.request.school.AutorisationType.forString(schoolTransportRegistrationRequestXml.getAutorisation().toString()));
        else
            schoolTransportRegistrationRequest.setAutorisation(fr.cg95.cvq.business.request.school.AutorisationType.getDefaultAutorisationType());
      
        schoolTransportRegistrationRequest.setFrereOuSoeurEcole(schoolTransportRegistrationRequestXml.getFrereOuSoeurAutorise().getFrereOuSoeurEcole());
      
        schoolTransportRegistrationRequest.setFrereOuSoeurPrenom(schoolTransportRegistrationRequestXml.getFrereOuSoeurAutorise().getFrereOuSoeurPrenom());
      
        List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorisesList = new ArrayList<fr.cg95.cvq.business.request.school.TiersInformations>(schoolTransportRegistrationRequestXml.sizeOfTiersAutorisesArray());
        for (TiersInformationsType object : schoolTransportRegistrationRequestXml.getTiersAutorisesArray()) {
            tiersAutorisesList.add(fr.cg95.cvq.business.request.school.TiersInformations.xmlToModel(object));
        }
        schoolTransportRegistrationRequest.setTiersAutorises(tiersAutorisesList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> arretList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(schoolTransportRegistrationRequestXml.sizeOfArretArray());
        for (LocalReferentialDataType object : schoolTransportRegistrationRequestXml.getArretArray()) {
            arretList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        schoolTransportRegistrationRequest.setArret(arretList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> ligneList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(schoolTransportRegistrationRequestXml.sizeOfLigneArray());
        for (LocalReferentialDataType object : schoolTransportRegistrationRequestXml.getLigneArray()) {
            ligneList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        schoolTransportRegistrationRequest.setLigne(ligneList);
      
        schoolTransportRegistrationRequest.setFrereOuSoeurClasse(schoolTransportRegistrationRequestXml.getFrereOuSoeurAutorise().getFrereOuSoeurClasse());
      
        return schoolTransportRegistrationRequest;
    }

    @Override
    public SchoolTransportRegistrationRequest clone() {
        SchoolTransportRegistrationRequest clone = new SchoolTransportRegistrationRequest(getRequestData().clone(), schoolTransportRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("enfant", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("autorisations", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setFrereOuSoeurNom(final String frereOuSoeurNom) {
        schoolTransportRegistrationRequestData.setFrereOuSoeurNom(frereOuSoeurNom);
    }

    
    public final String getFrereOuSoeurNom() {
        return schoolTransportRegistrationRequestData.getFrereOuSoeurNom();
    }
  
    public final void setAutorisation(final fr.cg95.cvq.business.request.school.AutorisationType autorisation) {
        schoolTransportRegistrationRequestData.setAutorisation(autorisation);
    }

    
    public final fr.cg95.cvq.business.request.school.AutorisationType getAutorisation() {
        return schoolTransportRegistrationRequestData.getAutorisation();
    }
  
    public final void setFrereOuSoeurEcole(final String frereOuSoeurEcole) {
        schoolTransportRegistrationRequestData.setFrereOuSoeurEcole(frereOuSoeurEcole);
    }

    
    public final String getFrereOuSoeurEcole() {
        return schoolTransportRegistrationRequestData.getFrereOuSoeurEcole();
    }
  
    public final void setFrereOuSoeurPrenom(final String frereOuSoeurPrenom) {
        schoolTransportRegistrationRequestData.setFrereOuSoeurPrenom(frereOuSoeurPrenom);
    }

    
    public final String getFrereOuSoeurPrenom() {
        return schoolTransportRegistrationRequestData.getFrereOuSoeurPrenom();
    }
  
    public final void setTiersAutorises(final List<fr.cg95.cvq.business.request.school.TiersInformations> tiersAutorises) {
        schoolTransportRegistrationRequestData.setTiersAutorises(tiersAutorises);
    }

    
    public final List<fr.cg95.cvq.business.request.school.TiersInformations> getTiersAutorises() {
        return schoolTransportRegistrationRequestData.getTiersAutorises();
    }
  
    public final void setArret(final List<fr.cg95.cvq.business.request.LocalReferentialData> arret) {
        schoolTransportRegistrationRequestData.setArret(arret);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getArret() {
        return schoolTransportRegistrationRequestData.getArret();
    }
  
    public final void setLigne(final List<fr.cg95.cvq.business.request.LocalReferentialData> ligne) {
        schoolTransportRegistrationRequestData.setLigne(ligne);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getLigne() {
        return schoolTransportRegistrationRequestData.getLigne();
    }
  
    public final void setFrereOuSoeurClasse(final String frereOuSoeurClasse) {
        schoolTransportRegistrationRequestData.setFrereOuSoeurClasse(frereOuSoeurClasse);
    }

    
    public final String getFrereOuSoeurClasse() {
        return schoolTransportRegistrationRequestData.getFrereOuSoeurClasse();
    }
  
}
