package com.epita.mti.nuitdelinfoandroid.activity;

import android.app.DatePickerDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.afollestad.materialdialogs.MaterialDialog;
import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.controller.CampaignController;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawer;
import com.epita.mti.nuitdelinfoandroid.fragment.HomeFragment;

import java.util.Calendar;

public class HomeActivity extends BaseActivity {

    private MenuDrawer mMenuDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        // Set up the menu drawer
        mMenuDrawer = new MenuDrawer(this);

        if (savedInstanceState == null) {
            mMenuDrawer.mAdapter.addFlux("Campagne 1", 42);

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new HomeFragment())
                    .commit();
        }

    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // add or remove item from drawer if needed here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mMenuDrawer.mDrawerLayout.isDrawerOpen(mMenuDrawer.mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mMenuDrawer.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        mMenuDrawer.mDrawerLayout.closeDrawers();

        // Handle action bar actions click
        int id = item.getItemId();

        if (id == R.id.action_search) {
            final MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title(getString(R.string.dialog_title_search))
                    .customView(R.layout.dialog_content_search)
                    .negativeText(getString(R.string.cancel))
                    .positiveText(getString(R.string.search))
                    .callback(new MaterialDialog.SimpleCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            // execute search
                            dialog.cancel();
                        }
                    })
                    .build();

            View customView = dialog.getCustomView();

            final Spinner sFromTo = (Spinner)customView.findViewById(R.id.from_to);
            ArrayAdapter<CharSequence> FromToAdapter = ArrayAdapter.createFromResource(this,
                    R.array.from_to_array, R.layout.spinner_text);
            FromToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sFromTo.setAdapter(FromToAdapter);

            final EditText tvDate = (EditText)customView.findViewById(R.id.date);
            tvDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar c = Calendar.getInstance();
                    DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(dayOfMonth);
                            sb.append("/");
                            sb.append(monthOfYear + 1);
                            sb.append("/");
                            sb.append(year);
                            tvDate.setText(sb.toString());
                        }
                    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.show();
                }
            });

            final Spinner sLength = (Spinner)customView.findViewById(R.id.length);
            ArrayAdapter<CharSequence> lengthAdapter = ArrayAdapter.createFromResource(this,
                    R.array.length_array, R.layout.spinner_text);
            lengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sLength.setAdapter(lengthAdapter);

            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mMenuDrawer.mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mMenuDrawer.mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
