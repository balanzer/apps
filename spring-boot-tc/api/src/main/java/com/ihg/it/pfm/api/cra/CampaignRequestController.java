/**
 *
 */
package com.ihg.it.pfm.api.cra;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cra", name = "CampaignProcesController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignRequestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRequestController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<String>> list() {
		LOGGER.debug("get all records");
		List<String> results = new ArrayList<>();
		results.add("1212");
		if (results.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
