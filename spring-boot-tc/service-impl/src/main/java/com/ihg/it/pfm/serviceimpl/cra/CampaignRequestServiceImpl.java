/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author varathm
 *
 */
@Service
public class CampaignRequestServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRequestServiceImpl.class);

    public String greetings(final String name) {
        LOGGER.debug("Service Invoked...");
        if ((null != name) && (name.trim().length() > 0)) {
            return "Hello " + name;
        } else {
            return "Hello Unknown";
        }
    }
}
