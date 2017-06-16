package com.ihg.it.pfm.services;

import com.ihg.it.pfm.services.error.ServiceException;

public interface CampaignRequestProcess {

    public String greetings(final String name) throws ServiceException;
}
