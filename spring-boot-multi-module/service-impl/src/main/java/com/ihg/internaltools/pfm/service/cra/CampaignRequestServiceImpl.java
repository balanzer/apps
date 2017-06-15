/**
 *
 */
package com.ihg.internaltools.pfm.service.cra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ihg.internaltools.pfm.CampaignRequestService;
import com.ihg.internaltools.pfm.cra.CampaignRequest;
import com.ihg.internaltools.pfm.error.ApplicationException;

/**
 * @author mv
 *
 */
@Service
public class CampaignRequestServiceImpl implements CampaignRequestService {

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.internaltools.pfm.CampaignRequestService#get(long)
     */
    @Override
    public CampaignRequest get(long id) throws ApplicationException {

        return new CampaignRequest();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.internaltools.pfm.CampaignRequestService#listAll()
     */
    @Override
    public List<CampaignRequest> listAll() throws ApplicationException {
        List<CampaignRequest> campaigns = new ArrayList<>();
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        campaigns.add(new CampaignRequest());
        return campaigns;
    }

}
