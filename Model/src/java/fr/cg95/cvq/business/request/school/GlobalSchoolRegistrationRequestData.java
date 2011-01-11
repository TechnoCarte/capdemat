
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
 *  table="global_school_registration_request"
 *  lazy="false"
 */
public class GlobalSchoolRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public GlobalSchoolRegistrationRequestData() {
      
        estDerogation = Boolean.valueOf(false);
      
        estRestauration = Boolean.valueOf(false);
      
        estPeriscolaire = Boolean.valueOf(false);
      
    }

    @Override
    public GlobalSchoolRegistrationRequestData clone() {
        GlobalSchoolRegistrationRequestData result = new GlobalSchoolRegistrationRequestData();
        
          
            
        result.setMotifAutrePrecision(motifAutrePrecision);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleSecteurList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : ecoleSecteur) {
            ecoleSecteurList.add(object.clone());
        }
        result.setEcoleSecteur(ecoleSecteurList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : motifsDerogation) {
            motifsDerogationList.add(object.clone());
        }
        result.setMotifsDerogation(motifsDerogationList);
      
          
        
          
            
        result.setEstDerogation(estDerogation);
      
          
        
          
            
        result.setInformationsComplementairesDerogation(informationsComplementairesDerogation);
      
          
        
          
            
        result.setEstRestauration(estRestauration);
      
          
        
          
            
        result.setEstPeriscolaire(estPeriscolaire);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : regimeAlimentaire) {
            regimeAlimentaireList.add(object.clone());
        }
        result.setRegimeAlimentaire(regimeAlimentaireList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleDerogationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : ecoleDerogation) {
            ecoleDerogationList.add(object.clone());
        }
        result.setEcoleDerogation(ecoleDerogationList);
      
          
        
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
          
            "if (_this.motifsDerogation == null || _this.motifsDerogation.isEmpty()) return false; _this.motifsDerogation.each { active &= _this.conditions['motifsDerogation'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifAutrePrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.motifsDerogation == null || _this.motifsDerogation.isEmpty()) return false; _this.motifsDerogation.each { active &= _this.conditions['motifsDerogation'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifAutrePrecision"
      )
    
    private String motifAutrePrecision;

    public final void setMotifAutrePrecision(final String motifAutrePrecision) {
        this.motifAutrePrecision = motifAutrePrecision;
    }

    /**
 
        * @hibernate.property
        *  column="motif_autre_precision"
        
      
    */
    public final String getMotifAutrePrecision() {
        return this.motifAutrePrecision;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "ecoleSecteur"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "ecoleSecteur"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleSecteur;

    public final void setEcoleSecteur(final List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleSecteur) {
        this.ecoleSecteur = ecoleSecteur;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="global_school_registration_request_ecole_secteur"
        * @hibernate.key
        *  column="global_school_registration_request_id"
        * @hibernate.list-index
        *  column="ecole_secteur_index"
        * @hibernate.many-to-many
        *  column="ecole_secteur_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getEcoleSecteur() {
        return this.ecoleSecteur;
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
        *  table="global_school_registration_request_motifs_derogation"
        * @hibernate.key
        *  column="global_school_registration_request_id"
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
  
    
      @MaxLength(
        
          value = 1024,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "informationsComplementairesDerogation"
      )
    
      @MatchPattern(
        
          pattern = "^.{0,1024}$",
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "informationsComplementairesDerogation"
      )
    
    private String informationsComplementairesDerogation;

    public final void setInformationsComplementairesDerogation(final String informationsComplementairesDerogation) {
        this.informationsComplementairesDerogation = informationsComplementairesDerogation;
    }

    /**
 
        * @hibernate.property
        *  column="informations_complementaires_derogation"
        *  length="1024"
      
    */
    public final String getInformationsComplementairesDerogation() {
        return this.informationsComplementairesDerogation;
    }
  
    
      @NotNull(
        
        
        profiles = {"restauration"},
        message = "estRestauration"
      )
    
    private Boolean estRestauration;

    public final void setEstRestauration(final Boolean estRestauration) {
        this.estRestauration = estRestauration;
    }

    /**
 
        * @hibernate.property
        *  column="est_restauration"
        
      
    */
    public final Boolean getEstRestauration() {
        return this.estRestauration;
    }
  
    
      @NotNull(
        
        
        profiles = {"periscolaire"},
        message = "estPeriscolaire"
      )
    
    private Boolean estPeriscolaire;

    public final void setEstPeriscolaire(final Boolean estPeriscolaire) {
        this.estPeriscolaire = estPeriscolaire;
    }

    /**
 
        * @hibernate.property
        *  column="est_periscolaire"
        
      
    */
    public final Boolean getEstPeriscolaire() {
        return this.estPeriscolaire;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"restauration"},
        message = "regimeAlimentaire"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"restauration"},
        message = "regimeAlimentaire"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaire;

    public final void setRegimeAlimentaire(final List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="global_school_registration_request_regime_alimentaire"
        * @hibernate.key
        *  column="global_school_registration_request_id"
        * @hibernate.list-index
        *  column="regime_alimentaire_index"
        * @hibernate.many-to-many
        *  column="regime_alimentaire_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRegimeAlimentaire() {
        return this.regimeAlimentaire;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "ecoleDerogation"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "ecoleDerogation"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleDerogation;

    public final void setEcoleDerogation(final List<fr.cg95.cvq.business.request.LocalReferentialData> ecoleDerogation) {
        this.ecoleDerogation = ecoleDerogation;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="global_school_registration_request_ecole_derogation"
        * @hibernate.key
        *  column="global_school_registration_request_id"
        * @hibernate.list-index
        *  column="ecole_derogation_index"
        * @hibernate.many-to-many
        *  column="ecole_derogation_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getEcoleDerogation() {
        return this.ecoleDerogation;
    }
  
}
