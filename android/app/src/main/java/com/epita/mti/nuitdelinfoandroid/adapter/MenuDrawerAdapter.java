package com.epita.mti.nuitdelinfoandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class MenuDrawerAdapter extends ArrayAdapter<MenuDrawerItem> {
    private static final String TAG = MenuDrawerAdapter.class.getSimpleName();

    private LayoutInflater mInflater;

    public ArrayList<MenuDrawerItem> mItems;

    public MenuDrawerAdapter(Context context, int textViewResourceId, ArrayList<MenuDrawerItem> items) {
        super(context, textViewResourceId, items);
        this.mItems = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final Holder holder;

        if (view == null) {
            // View doesn't exist so create it and create the holder
            view = mInflater.inflate(R.layout.item_drawer, parent, false);

            holder = new Holder();
            holder.imgIcon = (ImageView) view.findViewById(R.id.icon);
            holder.txtId = (TextView) view.findViewById(R.id.id);
            holder.txtTitle = (TextView) view.findViewById(R.id.title);

            view.setTag(holder);
        } else {
            // Just get our existing holder
            holder = (Holder) view.getTag();
        }

        // Populate via the holder for speed
        MenuDrawerItem item = getItem(position);

        holder.txtId.setText(String.valueOf(item.getId()));
        holder.txtTitle.setText(item.getTitle());
        //holder.imgIcon

        return view;
    }


    public void addFlux(String campaignName, int campaignId) {
        mItems.add(new MenuDrawerItem(campaignId, campaignName, android.R.drawable.arrow_down_float));
        notifyDataSetChanged();
    }

    // Holder class used to efficiently recycle view positions
    private static final class Holder {
        public ImageView imgIcon;
        public TextView txtId;
        public TextView txtTitle;
    }
}
