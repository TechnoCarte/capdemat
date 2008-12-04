package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="dhr_real_asset"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class DhrRealAsset implements Serializable {

    private static final long serialVersionUID = 1L;



    public DhrRealAsset() {
        super();
    }


    public final String modelToXmlString() {

        DhrRealAssetType object = (DhrRealAssetType) this.modelToXml();
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
        DhrRealAssetType dhrRealAsset = DhrRealAssetType.Factory.newInstance();
        if (this.realAssetNetFloorArea != null)
            dhrRealAsset.setRealAssetNetFloorArea(new BigInteger(this.realAssetNetFloorArea.toString()));
        if (this.dhrRealAssetAddress != null)
            dhrRealAsset.setDhrRealAssetAddress(Address.modelToXml(this.dhrRealAssetAddress));
        if (this.dhrRealAssetValue != null)
            dhrRealAsset.setDhrRealAssetValue(new BigInteger(this.dhrRealAssetValue.toString()));
        return dhrRealAsset;
    }

    public static DhrRealAsset xmlToModel(DhrRealAssetType dhrRealAssetDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrRealAsset dhrRealAsset = new DhrRealAsset();
        dhrRealAsset.setRealAssetNetFloorArea(dhrRealAssetDoc.getRealAssetNetFloorArea());
        if (dhrRealAssetDoc.getDhrRealAssetAddress() != null)
            dhrRealAsset.setDhrRealAssetAddress(Address.xmlToModel(dhrRealAssetDoc.getDhrRealAssetAddress()));
        dhrRealAsset.setDhrRealAssetValue(dhrRealAssetDoc.getDhrRealAssetValue());
        return dhrRealAsset;
    }

    private Long id;


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

    private java.math.BigInteger realAssetNetFloorArea;

    public final void setRealAssetNetFloorArea(final java.math.BigInteger realAssetNetFloorArea) {
        this.realAssetNetFloorArea = realAssetNetFloorArea;
    }


    /**
     * @hibernate.property
     *  column="real_asset_net_floor_area"
     *  type="serializable"
     */
    public final java.math.BigInteger getRealAssetNetFloorArea() {
        return this.realAssetNetFloorArea;
    }

    private fr.cg95.cvq.business.users.Address dhrRealAssetAddress;

    public final void setDhrRealAssetAddress(final fr.cg95.cvq.business.users.Address dhrRealAssetAddress) {
        this.dhrRealAssetAddress = dhrRealAssetAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="dhr_real_asset_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getDhrRealAssetAddress() {
        return this.dhrRealAssetAddress;
    }

    private java.math.BigInteger dhrRealAssetValue;

    public final void setDhrRealAssetValue(final java.math.BigInteger dhrRealAssetValue) {
        this.dhrRealAssetValue = dhrRealAssetValue;
    }


    /**
     * @hibernate.property
     *  column="dhr_real_asset_value"
     *  type="serializable"
     */
    public final java.math.BigInteger getDhrRealAssetValue() {
        return this.dhrRealAssetValue;
    }

}
