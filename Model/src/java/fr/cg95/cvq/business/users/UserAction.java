package fr.cg95.cvq.business.users;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.UserUtils;

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
        public static final Type DELETION = new Type("Deletion");
        public Type() { /* empty constructor for Hibernate */ }
        private Type(String type) { super(type); }
    }

    private Long id;
    private Date date;
    private Type type;
    private String note;
    private String data;

    protected UserAction() { /* empty constructor for Hibernate */ }

    public UserAction(Type type, Long targetId) {
        this(type, targetId, new JsonObject());
    }

    public UserAction(Type type, Long targetId, JsonObject payload) {
        date = new Date();
        this.type = type;
        JsonObject user = new JsonObject();
        user.addProperty("id", SecurityContext.getCurrentUserId());
        user.addProperty("name", UserUtils.getDisplayName(SecurityContext.getCurrentUserId()));
        payload.add("user", user);
        user = new JsonObject();
        user.addProperty("id", targetId);
        user.addProperty("name", UserUtils.getDisplayName(targetId));
        payload.add("target", user);
        data = new Gson().toJson(payload);
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
     * @hibernate.property
     *  column="data"
     */
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
