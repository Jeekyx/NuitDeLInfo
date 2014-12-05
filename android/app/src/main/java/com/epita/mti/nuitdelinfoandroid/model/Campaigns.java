package com.epita.mti.nuitdelinfoandroid.model;

import java.util.List;

/**
 * Created by yvan on 12/5/14.
 */
public class Campaigns extends Model {
    private List<Campaign> campaigns;

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
