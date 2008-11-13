package fr.cg95.cvq.business.request.leisure.music;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.leisure.music.*;

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
 *  table="music_school_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class MusicSchoolRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public MusicSchoolRegistrationRequest() {
        super();
    }


    public final String modelToXmlString() {

        MusicSchoolRegistrationRequestDocument object = (MusicSchoolRegistrationRequestDocument) this.modelToXml();
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
        MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc = MusicSchoolRegistrationRequestDocument.Factory.newInstance();
        MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest musicSchoolRegistrationRequest = musicSchoolRegistrationRequestDoc.addNewMusicSchoolRegistrationRequest();
        super.fillCommonXmlInfo(musicSchoolRegistrationRequest);
        int i = 0;
        if (activity != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] activityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[activity.size()];
            Iterator activityIt = activity.iterator();
            while (activityIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) activityIt.next();
                activityTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            musicSchoolRegistrationRequest.setActivityArray(activityTypeTab);
        }
        if (this.rulesAndRegulationsAcceptance != null)
            musicSchoolRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        return musicSchoolRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc =
            (MusicSchoolRegistrationRequestDocument) modelToXml();
        return musicSchoolRegistrationRequestDoc.getMusicSchoolRegistrationRequest();
    }

    public static MusicSchoolRegistrationRequest xmlToModel(MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc) {

        MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest musicSchoolRegistrationRequestXml = musicSchoolRegistrationRequestDoc.getMusicSchoolRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MusicSchoolRegistrationRequest musicSchoolRegistrationRequest = new MusicSchoolRegistrationRequest();
        musicSchoolRegistrationRequest.fillCommonModelInfo(musicSchoolRegistrationRequest,musicSchoolRegistrationRequestXml);
        List<fr.cg95.cvq.business.users.LocalReferentialData> activityList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( musicSchoolRegistrationRequestXml.sizeOfActivityArray() > 0) {
            for (int i = 0; i < musicSchoolRegistrationRequestXml.getActivityArray().length; i++) {
                activityList.add(LocalReferentialData.xmlToModel(musicSchoolRegistrationRequestXml.getActivityArray(i)));
            }
        }
        musicSchoolRegistrationRequest.setActivity(activityList);
        musicSchoolRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(musicSchoolRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        return musicSchoolRegistrationRequest;
    }

    private List<fr.cg95.cvq.business.users.LocalReferentialData> activity;

    public final void setActivity(final List<fr.cg95.cvq.business.users.LocalReferentialData> activity) {
        this.activity = activity;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="music_school_registration_request_activity"
     * @hibernate.key
     *  column="music_school_registration_request_id"
     * @hibernate.list-index
     *  column="activity_index"
     * @hibernate.many-to-many
     *  column="activity_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getActivity() {
        return this.activity;
    }

    private Boolean rulesAndRegulationsAcceptance;

    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }


    /**
     * @hibernate.property
     *  column="rules_and_regulations_acceptance"
     */
    public final Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }

}