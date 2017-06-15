/**
 * @author varathm - ApplicationExceptionHandler.java created Jun 14, 2017
 *
 * TODO
 */
package com.ihg.internaltools.pfm.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author varathm
 *
 */
@ControllerAdvice
@RestController
public class ApplicationExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public String handleBaseException(BaseException e) {
        LOGGER.error("message : {} ", e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        LOGGER.error("message : {} ", e.getMessage());
        return e.getMessage();
    }

}
