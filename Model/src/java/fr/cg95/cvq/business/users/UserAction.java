package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.security.SecurityContext;

/**
 * @hibernate.class
 *  table="user_action"
 *  lazy="false"
 */
public class UserAction {

    public static final class Type extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        //public static final Type CONTACT_MODIFICATION = new Type("ContactModification");
        //public static final Type IDENTITY_MODIFICATION = new Type("IdentityModification");
        //public static final Type ADDRESS_MODIFICATION = new Type("AddressModification");
        //public static final Type ROLE_MODIFICATION = new Type("RoleModification");
        public static final Type CREATION = new Type("Creation");
        public static final Type MODIFICATION = new Type("Modification");
        public static final Type STATE_CHANGE = new Type("StateChange");
        public Type() { /* empty constructor for Hibernate */ }
        private Type(String type) { super(type); }
    }

    private Long id;
    private Date date;
    private Type type;
    private Long userId;
    private Long targetId;
    private String note;
    private Map<String, Serializable> data;

    protected UserAction() {
        data = new HashMap<String, Serializable>();
    }

    public UserAction(Type type, Long targetId) {
        this();
        date = new Date();
        userId= SecurityContext.getCurrentUserId();
        if (userId == null) userId = -1L;
        this.type = type;
        this.targetId = targetId;
    }

    public UserAction(Type type, Long targetId, String note) {
        this(type, targetId);
        this.note = note;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="date"
     *  not-null="true"
     */
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @hibernate.property
     *  column="user_id"
     *  not-null="true"
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @hibernate.property
     *  column="target_id"
     *  not-null="true"
     */
    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * @hibernate.property
     *  column="type"
     *  not-null="true"
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @hibernate.property
     *  column="note"
     */
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @hibernate.map
     *  lazy="false"
     *  cascade="all"
     *  table="user_action_data"
     * @hibernate.key
     *  column="id"
     * @hibernate.index
     *  column="key"
     *  type="string"
     * @hibernate.element
     *  column="value"
     *  type="serializable"
     */
    public Map<String, Serializable> getData() {
        return data;
    }

    public void setData(Map<String, Serializable> data) {
        this.data = data;
    }
}
