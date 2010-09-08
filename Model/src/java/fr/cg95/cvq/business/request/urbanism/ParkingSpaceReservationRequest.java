
package fr.cg95.cvq.business.request.urbanism;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class ParkingSpaceReservationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = ParkingSpaceReservationRequestData.conditions;

    @AssertValid(message = "")
    private ParkingSpaceReservationRequestData parkingSpaceReservationRequestData;

    public ParkingSpaceReservationRequest(RequestData requestData, ParkingSpaceReservationRequestData parkingSpaceReservationRequestData) {
        super(requestData);
        this.parkingSpaceReservationRequestData = parkingSpaceReservationRequestData;
    }

    public ParkingSpaceReservationRequest() {
        super();
        this.parkingSpaceReservationRequestData = new ParkingSpaceReservationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public ParkingSpaceReservationRequestData getSpecificData() {
        return parkingSpaceReservationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(ParkingSpaceReservationRequestData parkingSpaceReservationRequestData) {
        this.parkingSpaceReservationRequestData = parkingSpaceReservationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        ParkingSpaceReservationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final ParkingSpaceReservationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        ParkingSpaceReservationRequestDocument parkingSpaceReservationRequestDoc = ParkingSpaceReservationRequestDocument.Factory.newInstance();
        ParkingSpaceReservationRequestDocument.ParkingSpaceReservationRequest parkingSpaceReservationRequest = parkingSpaceReservationRequestDoc.addNewParkingSpaceReservationRequest();
        super.fillCommonXmlInfo(parkingSpaceReservationRequest);
        int i = 0;
        
        date = getStartDate();
        if (date != null) {
            calendar.setTime(date);
            parkingSpaceReservationRequest.setStartDate(calendar);
        }
      
        parkingSpaceReservationRequest.setVoiePietonne(getVoiePietonne());
      
        if (getRequesterFirstAddressKind() != null)
            parkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.xml.request.urbanism.AccountAddressKindType.Enum.forString(getRequesterFirstAddressKind().toString()));
      
        i = 0;
        if (getDuration() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] durationTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getDuration().size()];
            for (LocalReferentialData object : getDuration()) {
              durationTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            parkingSpaceReservationRequest.setDurationArray(durationTypeTab);
        }
      
        if (getRequesterOtherAddress() != null)
            parkingSpaceReservationRequest.setRequesterOtherAddress(Address.modelToXml(getRequesterOtherAddress()));
      
        if (getRequesterFirstAddress() != null)
            parkingSpaceReservationRequest.setRequesterFirstAddress(Address.modelToXml(getRequesterFirstAddress()));
      
        if (getFurnitureLift() != null)
            parkingSpaceReservationRequest.setFurnitureLift(getFurnitureLift().booleanValue());
      
        if (getRequesterOtherAddressKind() != null)
            parkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.xml.request.urbanism.AccountAddressKindType.Enum.forString(getRequesterOtherAddressKind().toString()));
      
        return parkingSpaceReservationRequestDoc;
    }

    @Override
    public final ParkingSpaceReservationRequestDocument.ParkingSpaceReservationRequest modelToXmlRequest() {
        return modelToXml().getParkingSpaceReservationRequest();
    }

    public static ParkingSpaceReservationRequest xmlToModel(ParkingSpaceReservationRequestDocument parkingSpaceReservationRequestDoc) {
        ParkingSpaceReservationRequestDocument.ParkingSpaceReservationRequest parkingSpaceReservationRequestXml = parkingSpaceReservationRequestDoc.getParkingSpaceReservationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        ParkingSpaceReservationRequest parkingSpaceReservationRequest = new ParkingSpaceReservationRequest();
        parkingSpaceReservationRequest.fillCommonModelInfo(parkingSpaceReservationRequest, parkingSpaceReservationRequestXml);
        
        calendar = parkingSpaceReservationRequestXml.getStartDate();
        if (calendar != null) {
            parkingSpaceReservationRequest.setStartDate(calendar.getTime());
        }
      
        parkingSpaceReservationRequest.setVoiePietonne(parkingSpaceReservationRequestXml.getVoiePietonne());
      
        if (parkingSpaceReservationRequestXml.getRequesterFirstAddressKind() != null)
            parkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.forString(parkingSpaceReservationRequestXml.getRequesterFirstAddressKind().toString()));
        else
            parkingSpaceReservationRequest.setRequesterFirstAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> durationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(parkingSpaceReservationRequestXml.sizeOfDurationArray());
        for (LocalReferentialDataType object : parkingSpaceReservationRequestXml.getDurationArray()) {
            durationList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        parkingSpaceReservationRequest.setDuration(durationList);
      
        if (parkingSpaceReservationRequestXml.getRequesterOtherAddress() != null)
            parkingSpaceReservationRequest.setRequesterOtherAddress(Address.xmlToModel(parkingSpaceReservationRequestXml.getRequesterOtherAddress()));
      
        if (parkingSpaceReservationRequestXml.getRequesterFirstAddress() != null)
            parkingSpaceReservationRequest.setRequesterFirstAddress(Address.xmlToModel(parkingSpaceReservationRequestXml.getRequesterFirstAddress()));
      
        parkingSpaceReservationRequest.setFurnitureLift(Boolean.valueOf(parkingSpaceReservationRequestXml.getFurnitureLift()));
      
        if (parkingSpaceReservationRequestXml.getRequesterOtherAddressKind() != null)
            parkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.forString(parkingSpaceReservationRequestXml.getRequesterOtherAddressKind().toString()));
        else
            parkingSpaceReservationRequest.setRequesterOtherAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
        return parkingSpaceReservationRequest;
    }

  
    public final void setStartDate(final java.util.Date startDate) {
        parkingSpaceReservationRequestData.setStartDate(startDate);
    }

    
    public final java.util.Date getStartDate() {
        return parkingSpaceReservationRequestData.getStartDate();
    }
  
    public final void setVoiePietonne(final String voiePietonne) {
        parkingSpaceReservationRequestData.setVoiePietonne(voiePietonne);
    }

    
    public final String getVoiePietonne() {
        return parkingSpaceReservationRequestData.getVoiePietonne();
    }
  
    public final void setRequesterFirstAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind) {
        parkingSpaceReservationRequestData.setRequesterFirstAddressKind(requesterFirstAddressKind);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterFirstAddressKind() {
        return parkingSpaceReservationRequestData.getRequesterFirstAddressKind();
    }
  
    public final void setDuration(final List<fr.cg95.cvq.business.request.LocalReferentialData> duration) {
        parkingSpaceReservationRequestData.setDuration(duration);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getDuration() {
        return parkingSpaceReservationRequestData.getDuration();
    }
  
    public final void setRequesterOtherAddress(final fr.cg95.cvq.business.users.Address requesterOtherAddress) {
        parkingSpaceReservationRequestData.setRequesterOtherAddress(requesterOtherAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getRequesterOtherAddress() {
        return parkingSpaceReservationRequestData.getRequesterOtherAddress();
    }
  
    public final void setRequesterFirstAddress(final fr.cg95.cvq.business.users.Address requesterFirstAddress) {
        parkingSpaceReservationRequestData.setRequesterFirstAddress(requesterFirstAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getRequesterFirstAddress() {
        return parkingSpaceReservationRequestData.getRequesterFirstAddress();
    }
  
    public final void setFurnitureLift(final Boolean furnitureLift) {
        parkingSpaceReservationRequestData.setFurnitureLift(furnitureLift);
    }

    
    public final Boolean getFurnitureLift() {
        return parkingSpaceReservationRequestData.getFurnitureLift();
    }
  
    public final void setRequesterOtherAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind) {
        parkingSpaceReservationRequestData.setRequesterOtherAddressKind(requesterOtherAddressKind);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterOtherAddressKind() {
        return parkingSpaceReservationRequestData.getRequesterOtherAddressKind();
    }
  
}
