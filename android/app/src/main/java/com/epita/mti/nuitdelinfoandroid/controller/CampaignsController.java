package com.epita.mti.nuitdelinfoandroid.controller;

import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Campaigns;

/**
 * Created by yvan on 12/5/14.
 */
public class CampaignsController extends Controller {
    public CampaignsController() {
        mTableName = "campaigns";
    }

    public void getAll(ControllerCallback callback) {
        getAll(Campaigns.class, callback);
    }
}
