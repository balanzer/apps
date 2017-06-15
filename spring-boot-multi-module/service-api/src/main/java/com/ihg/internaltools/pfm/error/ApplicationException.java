/**
 *
 */
package com.ihg.internaltools.pfm.error;

/**
 * @author mv
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {

    /**
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
