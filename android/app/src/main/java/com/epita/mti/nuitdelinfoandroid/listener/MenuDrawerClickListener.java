package com.epita.mti.nuitdelinfoandroid.listener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.epita.mti.nuitdelinfoandroid.activity.FeedsActivity;
import com.epita.mti.nuitdelinfoandroid.app.AppController;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawer;

public class MenuDrawerClickListener implements ListView.OnItemClickListener {

    private final static String TAG = MenuDrawerClickListener.class.getSimpleName();

    private final MenuDrawer mMenuDrawer;
    private final Activity mActivity;

    public MenuDrawerClickListener(Activity activity, MenuDrawer menuDrawer) {
        mActivity = activity;
        mMenuDrawer = menuDrawer;
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
        switch (position) {
            case 0:
                //Intent intent = new Intent(mActivity, nextActivity);
                //nextActivity = (AppController.getInstance().userIsLogged()) ?
                //        AccountActivity.class : ConnectionActivity.class;
                break;
            default:
                Intent intent = new Intent(mActivity, FeedsActivity.class);
                intent.putExtra("campaign", mMenuDrawer.mAdapter.mItems.get(position - 1).getId());
                mActivity.startActivity(intent);
                break;
        }
    }
}
