package com.epita.mti.nuitdelinfoandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawerItem;

import java.util.ArrayList;

/**
 * Created by mrollin on 04/12/14.
 */
public class MenuDrawerAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MenuDrawerItem> mNavDrawerItems;

    public MenuDrawerAdapter(Context context, ArrayList<MenuDrawerItem> navDrawerItems) {
        mContext = context;
        mNavDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return mNavDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_drawer, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        imgIcon.setImageResource(mNavDrawerItems.get(position).getIcon());
        txtTitle.setText(mNavDrawerItems.get(position).getTitle());

        return convertView;
    }
}
