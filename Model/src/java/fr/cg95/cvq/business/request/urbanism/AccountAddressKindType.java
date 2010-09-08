package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class AccountAddressKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final AccountAddressKindType CURRENT = new AccountAddressKindType("Current");
  
    public static final AccountAddressKindType FUTURE = new AccountAddressKindType("Future");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private AccountAddressKindType(String value) {
        super(value);
    }

    public AccountAddressKindType() {}

    public static AccountAddressKindType[] allAccountAddressKindTypes = {
        CURRENT,
        FUTURE
    };

    public static AccountAddressKindType getDefaultAccountAddressKindType() {
        return null;
    }

    public static AccountAddressKindType forString(final String enumAsString) {
        for (AccountAddressKindType value : allAccountAddressKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAccountAddressKindType();
    }
}
