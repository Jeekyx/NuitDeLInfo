package com.epita.mti.nuitdelinfoandroid.listener;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.epita.mti.nuitdelinfoandroid.app.AppController;

/**
 * Created by mrollin on 04/12/14.
 */
public class MenuDrawerClickListener implements ListView.OnItemClickListener {

    private final static String TAG = MenuDrawerClickListener.class.getSimpleName();

    private final DrawerLayout mDrawerLayout;
    private final ListView mDrawerList;
    private final Activity mActivity;

    public MenuDrawerClickListener(Activity activity, DrawerLayout drawerLayout, ListView drawerList) {
        mActivity = activity;
        mDrawerLayout = drawerLayout;
        mDrawerList = drawerList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // display view for selected nav drawer item
        displayView(position);
    }

    /**
     * Displaying fragment view for selected nav drawer list item
     */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Class<?> nextActivity = null;
        switch (position) {
            case 0:
                //nextActivity = (AppController.getInstance().userIsLogged()) ?
                //        AccountActivity.class : ConnectionActivity.class;
                break;
            default:
                break;
        }

        if (nextActivity != null) {
            mDrawerLayout.closeDrawer(mDrawerList);
            mActivity.startActivity(new Intent(mActivity, nextActivity));
        } else {
            // error in creating fragment
            Log.e(TAG, "Error in creating fragment");
        }
    }
}
