package by.training.exception;


/**
 * The type Country not exist exception.
 */
public class CountryNotExistException extends Exception {
    /**
     * Instantiates a new Country not exist exception.
     */
    public CountryNotExistException() {
        super();
    }

    /**
     * Instantiates a new Country not exist exception.
     *
     * @param message the message
     */
    public CountryNotExistException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Country not exist exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CountryNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Country not exist exception.
     *
     * @param cause the cause
     */
    public CountryNotExistException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Country not exist exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected CountryNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
