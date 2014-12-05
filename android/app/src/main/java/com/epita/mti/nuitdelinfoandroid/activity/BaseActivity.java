package com.epita.mti.nuitdelinfoandroid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.epita.mti.nuitdelinfoandroid.R;

/**
 * Created by mrollin on 04/12/14.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private final String TAG = BaseActivity.class.getSimpleName();

    // The menu drawer
    private Toolbar toolbar;

    public Toolbar getToolBar() { return toolbar; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);
    }
}
