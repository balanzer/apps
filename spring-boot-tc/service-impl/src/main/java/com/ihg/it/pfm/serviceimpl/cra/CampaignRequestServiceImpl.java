/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.CampaignRequestProcess;
import com.ihg.it.pfm.services.error.ServiceException;

/**
 * @author varathm
 *
 */
@Service
public class CampaignRequestServiceImpl implements CampaignRequestProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRequestServiceImpl.class);

    @Override
    public List<CampaignRequest> getAll() throws ServiceException {
        LOGGER.debug("getAll - Get all campaign records");
        final List<CampaignRequest> records = new ArrayList<>();
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        records.add(new CampaignRequest());
        return records;
    }

}
