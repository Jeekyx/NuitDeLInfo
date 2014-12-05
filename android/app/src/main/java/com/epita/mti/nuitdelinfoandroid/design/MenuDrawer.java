package com.epita.mti.nuitdelinfoandroid.design;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.ListView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.activity.HomeActivity;
import com.epita.mti.nuitdelinfoandroid.adapter.MenuDrawerAdapter;
import com.epita.mti.nuitdelinfoandroid.listener.MenuDrawerClickListener;

import java.util.ArrayList;

public class MenuDrawer {

    private final static String TAG = MenuDrawer.class.getSimpleName();

    private HomeActivity mActivity;

    /**
     * The drawer menu
     */
    public DrawerLayout mDrawerLayout;
    public ListView mDrawerList;
    public ActionBarDrawerToggle mDrawerToggle;
    public MenuDrawerAdapter mAdapter;

    private String[] mNavMenuTitles;
    private ArrayList<MenuDrawerItem> mNavDrawerItems;

    public MenuDrawer(HomeActivity activity) {
        mActivity = activity;
        init();
    }

    /**
     * Initialize the menu drawer
     */
    private void init() {
        mDrawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) mActivity.findViewById(R.id.left_drawer);

        mNavDrawerItems = new ArrayList<>();

        // Set up the header
        final View header = mActivity.getLayoutInflater().inflate(R.layout.drawer_header, mDrawerList, false);
        mDrawerList.addHeaderView(header);

        // Setting the nav drawer list adapter
        mAdapter = new MenuDrawerAdapter(mActivity, 0, mNavDrawerItems);
        mDrawerList.setAdapter(mAdapter);

        // Enabling action bar app icon and behaving it as toggle button
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivity.getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout,
                mActivity.getToolBar(),
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Set the listener for the list within the drawer
        mDrawerList.setOnItemClickListener(new MenuDrawerClickListener(mActivity, this));
    }
}
