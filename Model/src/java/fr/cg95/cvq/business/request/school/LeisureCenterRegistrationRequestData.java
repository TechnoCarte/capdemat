
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

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="leisure_center_registration_request"
 *  lazy="false"
 */
public class LeisureCenterRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LeisureCenterRegistrationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
        estDerogation = Boolean.valueOf(false);
      
        estTransport = Boolean.valueOf(false);
      
    }

    @Override
    public LeisureCenterRegistrationRequestData clone() {
        LeisureCenterRegistrationRequestData result = new LeisureCenterRegistrationRequestData();
        
          
            
        result.setIdLigne(idLigne);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : motifsDerogation) {
            motifsDerogationList.add(object.clone());
        }
        result.setMotifsDerogation(motifsDerogationList);
      
          
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setIdArret(idArret);
      
          
        
          
            
        result.setEstDerogation(estDerogation);
      
          
        
          
            
        result.setLabelArret(labelArret);
      
          
        
          
            
        result.setLabelLigne(labelLigne);
      
          
        
          
            
        result.setIdCentreLoisirs(idCentreLoisirs);
      
          
        
          
            
        result.setEstTransport(estTransport);
      
          
        
          
            
        result.setLabelCentreLoisirs(labelCentreLoisirs);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> modeAccueilList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : modeAccueil) {
            modeAccueilList.add(object.clone());
        }
        result.setModeAccueil(modeAccueilList);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idLigne"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idLigne"
      )
    
    private String idLigne;

    public final void setIdLigne(final String idLigne) {
        this.idLigne = idLigne;
    }

    /**
 
        * @hibernate.property
        *  column="id_ligne"
        
      
    */
    public final String getIdLigne() {
        return this.idLigne;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogation"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogation"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogation;

    public final void setMotifsDerogation(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogation) {
        this.motifsDerogation = motifsDerogation;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="leisure_center_registration_request_motifs_derogation"
        * @hibernate.key
        *  column="leisure_center_registration_request_id"
        * @hibernate.list-index
        *  column="motifs_derogation_index"
        * @hibernate.many-to-many
        *  column="motifs_derogation_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogation() {
        return this.motifsDerogation;
    }
  
    
      @NotNull(
        
        
        profiles = {"reglements"},
        message = "acceptationReglementInterieur"
      )
    
    private Boolean acceptationReglementInterieur;

    public final void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        this.acceptationReglementInterieur = acceptationReglementInterieur;
    }

    /**
 
        * @hibernate.property
        *  column="acceptation_reglement_interieur"
        
      
    */
    public final Boolean getAcceptationReglementInterieur() {
        return this.acceptationReglementInterieur;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idArret"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idArret"
      )
    
    private String idArret;

    public final void setIdArret(final String idArret) {
        this.idArret = idArret;
    }

    /**
 
        * @hibernate.property
        *  column="id_arret"
        
      
    */
    public final String getIdArret() {
        return this.idArret;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estDerogation"
      )
    
    private Boolean estDerogation;

    public final void setEstDerogation(final Boolean estDerogation) {
        this.estDerogation = estDerogation;
    }

    /**
 
        * @hibernate.property
        *  column="est_derogation"
        
      
    */
    public final Boolean getEstDerogation() {
        return this.estDerogation;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelArret"
      )
    
    private String labelArret;

    public final void setLabelArret(final String labelArret) {
        this.labelArret = labelArret;
    }

    /**
 
        * @hibernate.property
        *  column="label_arret"
        
      
    */
    public final String getLabelArret() {
        return this.labelArret;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelLigne"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estTransport'].test(_this.estTransport.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelLigne"
      )
    
    private String labelLigne;

    public final void setLabelLigne(final String labelLigne) {
        this.labelLigne = labelLigne;
    }

    /**
 
        * @hibernate.property
        *  column="label_ligne"
        
      
    */
    public final String getLabelLigne() {
        return this.labelLigne;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "idCentreLoisirs"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "idCentreLoisirs"
      )
    
    private String idCentreLoisirs;

    public final void setIdCentreLoisirs(final String idCentreLoisirs) {
        this.idCentreLoisirs = idCentreLoisirs;
    }

    /**
 
        * @hibernate.property
        *  column="id_centre_loisirs"
        
      
    */
    public final String getIdCentreLoisirs() {
        return this.idCentreLoisirs;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estTransport"
      )
    
    private Boolean estTransport;

    public final void setEstTransport(final Boolean estTransport) {
        this.estTransport = estTransport;
    }

    /**
 
        * @hibernate.property
        *  column="est_transport"
        
      
    */
    public final Boolean getEstTransport() {
        return this.estTransport;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "labelCentreLoisirs"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "labelCentreLoisirs"
      )
    
    private String labelCentreLoisirs;

    public final void setLabelCentreLoisirs(final String labelCentreLoisirs) {
        this.labelCentreLoisirs = labelCentreLoisirs;
    }

    /**
 
        * @hibernate.property
        *  column="label_centre_loisirs"
        
      
    */
    public final String getLabelCentreLoisirs() {
        return this.labelCentreLoisirs;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"enfant"},
        message = "modeAccueil"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"enfant"},
        message = "modeAccueil"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> modeAccueil;

    public final void setModeAccueil(final List<fr.cg95.cvq.business.request.LocalReferentialData> modeAccueil) {
        this.modeAccueil = modeAccueil;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="leisure_center_registration_request_mode_accueil"
        * @hibernate.key
        *  column="leisure_center_registration_request_id"
        * @hibernate.list-index
        *  column="mode_accueil_index"
        * @hibernate.many-to-many
        *  column="mode_accueil_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getModeAccueil() {
        return this.modeAccueil;
    }
  
}
