package com.ihg.it.pfm.services;

import java.util.List;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.error.ServiceException;

public interface CampaignRequestProcess {

    public List<CampaignRequest> getAll() throws ServiceException;
}
