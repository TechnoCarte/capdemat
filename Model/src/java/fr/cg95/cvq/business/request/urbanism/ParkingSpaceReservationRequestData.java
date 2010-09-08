
package fr.cg95.cvq.business.request.urbanism;

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
 *  table="parking_space_reservation_request"
 *  lazy="false"
 */
public class ParkingSpaceReservationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public ParkingSpaceReservationRequestData() {
      
        furnitureLift = Boolean.valueOf(false);
      
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
        
        
        profiles = {"reservation"},
        message = "startDate"
      )
    
    private java.util.Date startDate;

    public final void setStartDate(final java.util.Date startDate) {
        this.startDate = startDate;
    }

    /**
 
        * @hibernate.property
        *  column="start_date"
        
      
    */
    public final java.util.Date getStartDate() {
        return this.startDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"complement"},
        message = "voiePietonne"
      )
    
      @NotBlank(
        
        
        profiles = {"complement"},
        message = "voiePietonne"
      )
    
    private String voiePietonne;

    public final void setVoiePietonne(final String voiePietonne) {
        this.voiePietonne = voiePietonne;
    }

    /**
 
        * @hibernate.property
        *  column="voie_pietonne"
        
      
    */
    public final String getVoiePietonne() {
        return this.voiePietonne;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "requesterFirstAddressKind"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind;

    public final void setRequesterFirstAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind) {
        this.requesterFirstAddressKind = requesterFirstAddressKind;
    }

    /**
 
        * @hibernate.property
        *  column="requester_first_address_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterFirstAddressKind() {
        return this.requesterFirstAddressKind;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"reservation"},
        message = "duration"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"reservation"},
        message = "duration"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> duration;

    public final void setDuration(final List<fr.cg95.cvq.business.request.LocalReferentialData> duration) {
        this.duration = duration;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="parking_space_reservation_request_duration"
        * @hibernate.key
        *  column="parking_space_reservation_request_id"
        * @hibernate.list-index
        *  column="duration_index"
        * @hibernate.many-to-many
        *  column="duration_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getDuration() {
        return this.duration;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "requesterOtherAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"reservation"},
        message = "requesterOtherAddress"
      )
    
    private fr.cg95.cvq.business.users.Address requesterOtherAddress;

    public final void setRequesterOtherAddress(final fr.cg95.cvq.business.users.Address requesterOtherAddress) {
        this.requesterOtherAddress = requesterOtherAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="requester_other_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getRequesterOtherAddress() {
        return this.requesterOtherAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "requesterFirstAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"reservation"},
        message = "requesterFirstAddress"
      )
    
    private fr.cg95.cvq.business.users.Address requesterFirstAddress;

    public final void setRequesterFirstAddress(final fr.cg95.cvq.business.users.Address requesterFirstAddress) {
        this.requesterFirstAddress = requesterFirstAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="requester_first_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getRequesterFirstAddress() {
        return this.requesterFirstAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "furnitureLift"
      )
    
    private Boolean furnitureLift;

    public final void setFurnitureLift(final Boolean furnitureLift) {
        this.furnitureLift = furnitureLift;
    }

    /**
 
        * @hibernate.property
        *  column="furniture_lift"
        
      
    */
    public final Boolean getFurnitureLift() {
        return this.furnitureLift;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "requesterOtherAddressKind"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind;

    public final void setRequesterOtherAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind) {
        this.requesterOtherAddressKind = requesterOtherAddressKind;
    }

    /**
 
        * @hibernate.property
        *  column="requester_other_address_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterOtherAddressKind() {
        return this.requesterOtherAddressKind;
    }
  
}
