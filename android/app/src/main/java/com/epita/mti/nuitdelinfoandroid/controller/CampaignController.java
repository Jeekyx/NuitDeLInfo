package com.epita.mti.nuitdelinfoandroid.controller;

import com.epita.mti.nuitdelinfoandroid.model.Campaign;

/**
 * Created by yvan on 12/5/14.
 */
public class CampaignController extends Controller<Campaign> {
    public CampaignController() {
        mTableName = "campaigns";
    }

    public void get(final int id, ControllerCallback callback) {
        get(Campaign.class, id, callback);
    }
}
