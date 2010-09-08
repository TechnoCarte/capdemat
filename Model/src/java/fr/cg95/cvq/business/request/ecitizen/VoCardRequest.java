
package fr.cg95.cvq.business.request.ecitizen;

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
import fr.cg95.cvq.xml.request.ecitizen.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class VoCardRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = VoCardRequestData.conditions;

    @AssertValid(message = "")
    private VoCardRequestData voCardRequestData;

    public VoCardRequest(RequestData requestData, VoCardRequestData voCardRequestData) {
        super(requestData);
        this.voCardRequestData = voCardRequestData;
    }

    public VoCardRequest() {
        super();
        this.voCardRequestData = new VoCardRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public VoCardRequestData getSpecificData() {
        return voCardRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(VoCardRequestData voCardRequestData) {
        this.voCardRequestData = voCardRequestData;
    }

    @Override
    public final String modelToXmlString() {
        VoCardRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final VoCardRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        VoCardRequestDocument voCardRequestDoc = VoCardRequestDocument.Factory.newInstance();
        VoCardRequestDocument.VoCardRequest voCardRequest = voCardRequestDoc.addNewVoCardRequest();
        super.fillCommonXmlInfo(voCardRequest);
        int i = 0;
        
        return voCardRequestDoc;
    }

    @Override
    public final VoCardRequestDocument.VoCardRequest modelToXmlRequest() {
        return modelToXml().getVoCardRequest();
    }

    public static VoCardRequest xmlToModel(VoCardRequestDocument voCardRequestDoc) {
        VoCardRequestDocument.VoCardRequest voCardRequestXml = voCardRequestDoc.getVoCardRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        VoCardRequest voCardRequest = new VoCardRequest();
        voCardRequest.fillCommonModelInfo(voCardRequest, voCardRequestXml);
        
        return voCardRequest;
    }

  
}
