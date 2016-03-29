package by.training.exception;


/**
 * The type Parse number exception.
 */
public class ParseNumberException extends Exception {

    /**
     * Instantiates a new Parse number exception.
     */
    public ParseNumberException() {
        super();
    }

    /**
     * Instantiates a new Parse number exception.
     *
     * @param message the message
     */
    public ParseNumberException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Parse number exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ParseNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Parse number exception.
     *
     * @param cause the cause
     */
    public ParseNumberException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Parse number exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected ParseNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
