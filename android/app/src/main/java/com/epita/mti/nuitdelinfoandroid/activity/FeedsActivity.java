package com.epita.mti.nuitdelinfoandroid.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.fragment.CampaignFragment;
import com.epita.mti.nuitdelinfoandroid.fragment.FeedsFragment;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;

/**
 * Created by yvan on 12/4/14.
 */
public class FeedsActivity extends BaseActivity {
    private final String TAG = FeedsActivity.class.getSimpleName();

    private int mCampaignId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_feeds);
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCampaignId = getIntent().getIntExtra("campaign", -1);

        if (mCampaignId <= -1) {
            Log.e(TAG, "There is no campaign_id added as extra. Unable to launch activity.");
            this.finish();
        }

        if (savedInstanceState == null) {
            FeedsFragment fragment = new FeedsFragment();
            Bundle args = new Bundle();
            args.putInt("campaign", mCampaignId);
            fragment.setArguments(args);

            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feeds, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                // Finish this activity if the home button is pressed (return to HomeActivity)
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
