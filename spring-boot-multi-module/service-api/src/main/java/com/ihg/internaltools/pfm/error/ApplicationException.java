/**
 *
 */
package com.ihg.internaltools.pfm.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mv
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);

    /**
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
        LOGGER.error("Error : {}", message);
    }

    /**
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error("Error : {}", message);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error("Error : {}", message);
    }

    /**
     * @param cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
        LOGGER.error("Error : {}", cause.getMessage());
    }

}
