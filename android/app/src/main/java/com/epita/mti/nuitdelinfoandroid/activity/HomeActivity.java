package com.epita.mti.nuitdelinfoandroid.activity;

import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawer;
import com.epita.mti.nuitdelinfoandroid.fragment.HomeFragment;


public class HomeActivity extends BaseActivity {

    private MenuDrawer mMenuDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        // Set up the menu drawer
        mMenuDrawer = new MenuDrawer(this);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new HomeFragment())
                    .commit();
        }
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
