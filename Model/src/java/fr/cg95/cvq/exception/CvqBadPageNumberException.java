package fr.cg95.cvq.exception;

/**
 * Exception raised when a bad page number is used while manipulating a document's binary data.
 *
 * @author bor@zenexity.fr
 */
public class CvqBadPageNumberException extends CvqException {

    public CvqBadPageNumberException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqBadPageNumberException() {
        super();
    }

    public CvqBadPageNumberException(final String reason) {
        super(reason);
    }
}
