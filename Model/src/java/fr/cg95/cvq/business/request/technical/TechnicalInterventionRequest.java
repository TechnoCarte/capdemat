package fr.cg95.cvq.business.request.technical;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.technical.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="technical_intervention_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class TechnicalInterventionRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public TechnicalInterventionRequest() {
        super();
    }


    public final String modelToXmlString() {

        TechnicalInterventionRequestDocument object = (TechnicalInterventionRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        TechnicalInterventionRequestDocument technicalInterventionRequestDoc = TechnicalInterventionRequestDocument.Factory.newInstance();
        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequest = technicalInterventionRequestDoc.addNewTechnicalInterventionRequest();
        super.fillCommonXmlInfo(technicalInterventionRequest);
        technicalInterventionRequest.setInterventionDescription(this.interventionDescription);
        if (this.interventionPlace != null)
            technicalInterventionRequest.setInterventionPlace(Address.modelToXml(this.interventionPlace));
        int i = 0;
        if (interventionType != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interventionTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[interventionType.size()];
            Iterator interventionTypeIt = interventionType.iterator();
            while (interventionTypeIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) interventionTypeIt.next();
                interventionTypeTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            technicalInterventionRequest.setInterventionTypeArray(interventionTypeTypeTab);
        }
        return technicalInterventionRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        TechnicalInterventionRequestDocument technicalInterventionRequestDoc =
            (TechnicalInterventionRequestDocument) modelToXml();
        return technicalInterventionRequestDoc.getTechnicalInterventionRequest();
    }

    public static TechnicalInterventionRequest xmlToModel(TechnicalInterventionRequestDocument technicalInterventionRequestDoc) {

        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequestXml = technicalInterventionRequestDoc.getTechnicalInterventionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        TechnicalInterventionRequest technicalInterventionRequest = new TechnicalInterventionRequest();
        technicalInterventionRequest.fillCommonModelInfo(technicalInterventionRequest,technicalInterventionRequestXml);
        technicalInterventionRequest.setInterventionDescription(technicalInterventionRequestXml.getInterventionDescription());
        if (technicalInterventionRequestXml.getInterventionPlace() != null)
            technicalInterventionRequest.setInterventionPlace(Address.xmlToModel(technicalInterventionRequestXml.getInterventionPlace()));
        List<fr.cg95.cvq.business.users.LocalReferentialData> interventionTypeList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( technicalInterventionRequestXml.sizeOfInterventionTypeArray() > 0) {
            for (int i = 0; i < technicalInterventionRequestXml.getInterventionTypeArray().length; i++) {
                interventionTypeList.add(LocalReferentialData.xmlToModel(technicalInterventionRequestXml.getInterventionTypeArray(i)));
            }
        }
        technicalInterventionRequest.setInterventionType(interventionTypeList);
        return technicalInterventionRequest;
    }

    private String interventionDescription;

    public final void setInterventionDescription(final String interventionDescription) {
        this.interventionDescription = interventionDescription;
    }


    /**
     * @hibernate.property
     *  column="intervention_description"
     */
    public final String getInterventionDescription() {
        return this.interventionDescription;
    }

    private fr.cg95.cvq.business.users.Address interventionPlace;

    public final void setInterventionPlace(final fr.cg95.cvq.business.users.Address interventionPlace) {
        this.interventionPlace = interventionPlace;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="intervention_place_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getInterventionPlace() {
        return this.interventionPlace;
    }

    private List<fr.cg95.cvq.business.users.LocalReferentialData> interventionType;

    public final void setInterventionType(final List<fr.cg95.cvq.business.users.LocalReferentialData> interventionType) {
        this.interventionType = interventionType;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="technical_intervention_request_intervention_type"
     * @hibernate.key
     *  column="technical_intervention_request_id"
     * @hibernate.list-index
     *  column="intervention_type_index"
     * @hibernate.many-to-many
     *  column="intervention_type_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getInterventionType() {
        return this.interventionType;
    }

}