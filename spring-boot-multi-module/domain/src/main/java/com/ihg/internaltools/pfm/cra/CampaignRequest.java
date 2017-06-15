package com.ihg.internaltools.pfm.cra;

public class CampaignRequest {
	private long id;

	private Requester requester;

	private Vendor vendor;

	private Campaign campaign;
	private Audit audit;
	private Tracking tracking;

	public Audit getAudit() {
		return audit;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public long getId() {
		return id;
	}

	public Requester getRequester() {
		return requester;
	}

	public Tracking getTracking() {
		return tracking;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRequester(Requester requester) {
		this.requester = requester;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
