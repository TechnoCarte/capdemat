
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
public class LeisureCenterRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = LeisureCenterRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData;

    public LeisureCenterRegistrationRequest(RequestData requestData, LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData) {
        super(requestData);
        this.leisureCenterRegistrationRequestData = leisureCenterRegistrationRequestData;
    }

    public LeisureCenterRegistrationRequest() {
        super();
        this.leisureCenterRegistrationRequestData = new LeisureCenterRegistrationRequestData();
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
          getStepStates().put("reglements", stepState);
        
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
    public LeisureCenterRegistrationRequestData getSpecificData() {
        return leisureCenterRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(LeisureCenterRegistrationRequestData leisureCenterRegistrationRequestData) {
        this.leisureCenterRegistrationRequestData = leisureCenterRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        LeisureCenterRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final LeisureCenterRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        LeisureCenterRegistrationRequestDocument leisureCenterRegistrationRequestDoc = LeisureCenterRegistrationRequestDocument.Factory.newInstance();
        LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest leisureCenterRegistrationRequest = leisureCenterRegistrationRequestDoc.addNewLeisureCenterRegistrationRequest();
        super.fillCommonXmlInfo(leisureCenterRegistrationRequest);
        int i = 0;
          TransportsType transportsTypeTransports = leisureCenterRegistrationRequest.addNewTransports();
        transportsTypeTransports.setIdLigne(getIdLigne());
      
        i = 0;
        if (getMotifsDerogation() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] motifsDerogationTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getMotifsDerogation().size()];
            for (LocalReferentialData object : getMotifsDerogation()) {
              motifsDerogationTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            leisureCenterRegistrationRequest.setMotifsDerogationArray(motifsDerogationTypeTab);
        }
      
        if (getAcceptationReglementInterieur() != null)
            leisureCenterRegistrationRequest.setAcceptationReglementInterieur(getAcceptationReglementInterieur().booleanValue());
      
        transportsTypeTransports.setIdArret(getIdArret());
      
        if (getEstDerogation() != null)
            leisureCenterRegistrationRequest.setEstDerogation(getEstDerogation().booleanValue());
      
        transportsTypeTransports.setLabelArret(getLabelArret());
      
        transportsTypeTransports.setLabelLigne(getLabelLigne());
        CentreLoisirsType centreLoisirsTypeCentresLoisirs = leisureCenterRegistrationRequest.addNewCentresLoisirs();
        centreLoisirsTypeCentresLoisirs.setIdCentreLoisirs(getIdCentreLoisirs());
      
        if (getEstTransport() != null)
            leisureCenterRegistrationRequest.setEstTransport(getEstTransport().booleanValue());
      
        centreLoisirsTypeCentresLoisirs.setLabelCentreLoisirs(getLabelCentreLoisirs());
      
        i = 0;
        if (getModeAccueil() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] modeAccueilTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getModeAccueil().size()];
            for (LocalReferentialData object : getModeAccueil()) {
              modeAccueilTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            leisureCenterRegistrationRequest.setModeAccueilArray(modeAccueilTypeTab);
        }
      
        return leisureCenterRegistrationRequestDoc;
    }

    @Override
    public final LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest modelToXmlRequest() {
        return modelToXml().getLeisureCenterRegistrationRequest();
    }

    public static LeisureCenterRegistrationRequest xmlToModel(LeisureCenterRegistrationRequestDocument leisureCenterRegistrationRequestDoc) {
        LeisureCenterRegistrationRequestDocument.LeisureCenterRegistrationRequest leisureCenterRegistrationRequestXml = leisureCenterRegistrationRequestDoc.getLeisureCenterRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LeisureCenterRegistrationRequest leisureCenterRegistrationRequest = new LeisureCenterRegistrationRequest();
        leisureCenterRegistrationRequest.fillCommonModelInfo(leisureCenterRegistrationRequest, leisureCenterRegistrationRequestXml);
        
        leisureCenterRegistrationRequest.setIdLigne(leisureCenterRegistrationRequestXml.getTransports().getIdLigne());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(leisureCenterRegistrationRequestXml.sizeOfMotifsDerogationArray());
        for (LocalReferentialDataType object : leisureCenterRegistrationRequestXml.getMotifsDerogationArray()) {
            motifsDerogationList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        leisureCenterRegistrationRequest.setMotifsDerogation(motifsDerogationList);
      
        leisureCenterRegistrationRequest.setAcceptationReglementInterieur(Boolean.valueOf(leisureCenterRegistrationRequestXml.getAcceptationReglementInterieur()));
      
        leisureCenterRegistrationRequest.setIdArret(leisureCenterRegistrationRequestXml.getTransports().getIdArret());
      
        leisureCenterRegistrationRequest.setEstDerogation(Boolean.valueOf(leisureCenterRegistrationRequestXml.getEstDerogation()));
      
        leisureCenterRegistrationRequest.setLabelArret(leisureCenterRegistrationRequestXml.getTransports().getLabelArret());
      
        leisureCenterRegistrationRequest.setLabelLigne(leisureCenterRegistrationRequestXml.getTransports().getLabelLigne());
      
        leisureCenterRegistrationRequest.setIdCentreLoisirs(leisureCenterRegistrationRequestXml.getCentresLoisirs().getIdCentreLoisirs());
      
        leisureCenterRegistrationRequest.setEstTransport(Boolean.valueOf(leisureCenterRegistrationRequestXml.getEstTransport()));
      
        leisureCenterRegistrationRequest.setLabelCentreLoisirs(leisureCenterRegistrationRequestXml.getCentresLoisirs().getLabelCentreLoisirs());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> modeAccueilList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(leisureCenterRegistrationRequestXml.sizeOfModeAccueilArray());
        for (LocalReferentialDataType object : leisureCenterRegistrationRequestXml.getModeAccueilArray()) {
            modeAccueilList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        leisureCenterRegistrationRequest.setModeAccueil(modeAccueilList);
      
        return leisureCenterRegistrationRequest;
    }

    @Override
    public LeisureCenterRegistrationRequest clone() {
        LeisureCenterRegistrationRequest clone = new LeisureCenterRegistrationRequest(getRequestData().clone(), leisureCenterRegistrationRequestData.clone());
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
          clone.getStepStates().put("reglements", stepState);
        
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

  
    public final void setIdLigne(final String idLigne) {
        leisureCenterRegistrationRequestData.setIdLigne(idLigne);
    }

    
    public final String getIdLigne() {
        return leisureCenterRegistrationRequestData.getIdLigne();
    }
  
    public final void setMotifsDerogation(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogation) {
        leisureCenterRegistrationRequestData.setMotifsDerogation(motifsDerogation);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogation() {
        return leisureCenterRegistrationRequestData.getMotifsDerogation();
    }
  
    public final void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        leisureCenterRegistrationRequestData.setAcceptationReglementInterieur(acceptationReglementInterieur);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglementInterieur() {
        return leisureCenterRegistrationRequestData.getAcceptationReglementInterieur();
    }
  
    public final void setIdArret(final String idArret) {
        leisureCenterRegistrationRequestData.setIdArret(idArret);
    }

    
    public final String getIdArret() {
        return leisureCenterRegistrationRequestData.getIdArret();
    }
  
    public final void setEstDerogation(final Boolean estDerogation) {
        leisureCenterRegistrationRequestData.setEstDerogation(estDerogation);
    }

    
    public final Boolean getEstDerogation() {
        return leisureCenterRegistrationRequestData.getEstDerogation();
    }
  
    public final void setLabelArret(final String labelArret) {
        leisureCenterRegistrationRequestData.setLabelArret(labelArret);
    }

    
    public final String getLabelArret() {
        return leisureCenterRegistrationRequestData.getLabelArret();
    }
  
    public final void setLabelLigne(final String labelLigne) {
        leisureCenterRegistrationRequestData.setLabelLigne(labelLigne);
    }

    
    public final String getLabelLigne() {
        return leisureCenterRegistrationRequestData.getLabelLigne();
    }
  
    public final void setIdCentreLoisirs(final String idCentreLoisirs) {
        leisureCenterRegistrationRequestData.setIdCentreLoisirs(idCentreLoisirs);
    }

    
    public final String getIdCentreLoisirs() {
        return leisureCenterRegistrationRequestData.getIdCentreLoisirs();
    }
  
    public final void setEstTransport(final Boolean estTransport) {
        leisureCenterRegistrationRequestData.setEstTransport(estTransport);
    }

    
    public final Boolean getEstTransport() {
        return leisureCenterRegistrationRequestData.getEstTransport();
    }
  
    public final void setLabelCentreLoisirs(final String labelCentreLoisirs) {
        leisureCenterRegistrationRequestData.setLabelCentreLoisirs(labelCentreLoisirs);
    }

    
    public final String getLabelCentreLoisirs() {
        return leisureCenterRegistrationRequestData.getLabelCentreLoisirs();
    }
  
    public final void setModeAccueil(final List<fr.cg95.cvq.business.request.LocalReferentialData> modeAccueil) {
        leisureCenterRegistrationRequestData.setModeAccueil(modeAccueil);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getModeAccueil() {
        return leisureCenterRegistrationRequestData.getModeAccueil();
    }
  
}
