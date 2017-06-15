/**
 * @author varathm - CampaignProcesController.java created Jun 14, 2017
 *
 * TODO
 */
package com.ihg.internaltools.pfm.api.cra;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.internaltools.pfm.CampaignRequestService;
import com.ihg.internaltools.pfm.cra.CampaignRequest;
import com.ihg.internaltools.pfm.error.ApplicationException;

@RestController
@RequestMapping(value = "/cra", name = "CampaignProcesController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignProcesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignProcesController.class);

    @Autowired
    protected CampaignRequestService campaignService;

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity exceptionHandler(ApplicationException e) {
        LOGGER.info("CampaignProcesController - Exception Handler - Error : {} ", e.getMessage());

        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignRequest>> list() {
        LOGGER.info("get all campaign requests");
        List<CampaignRequest> campaigns = this.campaignService.listAll();
        if (campaigns.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }
}
