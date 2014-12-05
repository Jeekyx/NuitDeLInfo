package com.epita.mti.nuitdelinfoandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.controller.CampaignController;
import com.epita.mti.nuitdelinfoandroid.controller.ControllerCallback;
import com.epita.mti.nuitdelinfoandroid.fragment.CampaignFragment;
import com.epita.mti.nuitdelinfoandroid.fragment.HomeFragment;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Model;

/**
 * Created by yvan on 12/4/14.
 */
public class CampaignActivity extends BaseActivity {
    private int mCampaignId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_campaign);
        super.onCreate(savedInstanceState);

        mCampaignId = getIntent().getExtras().getInt("campaign");

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, createFragment(mCampaignId))
                    .commit();
        }
    }


    public void displayFeeds(View view) {
        Intent intent = new Intent(this, FeedsActivity.class);
        intent.putExtra("campaign", mCampaignId);
        startActivity(intent);
    }

    private static CampaignFragment createFragment(int campaignId) {
        CampaignFragment fragment = new CampaignFragment();
        Bundle args = new Bundle();
        args.putInt("campaign", campaignId);
        fragment.setArguments(args);
        return fragment;
    }
}
