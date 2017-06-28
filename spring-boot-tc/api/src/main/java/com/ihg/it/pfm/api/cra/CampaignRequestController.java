/**
 *
 */
package com.ihg.it.pfm.api.cra;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.CampaignRequestProcess;

@RestController
@RequestMapping(value = "/cra", name = "CampaignProcesController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignRequestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRequestController.class);

    @Autowired
    private CampaignRequestProcess campaignService;

    @RequestMapping("/")
    public HttpEntity<String> defaultAction() {

        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignRequest>> list() {
        LOGGER.debug("get all records");

        final List<CampaignRequest> results = this.campaignService.getAll();

        if (results.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
