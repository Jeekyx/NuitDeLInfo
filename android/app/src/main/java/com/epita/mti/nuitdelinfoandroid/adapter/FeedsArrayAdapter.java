package com.epita.mti.nuitdelinfoandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.fragment.FeedsFragment;
import com.epita.mti.nuitdelinfoandroid.model.Feed;

/**
 * Created by yvan on 12/5/14.
 */
public class FeedsArrayAdapter extends ArrayAdapter<Feed> {
    private final Context context;
    private final Feed[] values;

    public FeedsArrayAdapter(Context context, Feed[] values) {
        super(context, R.layout.feed_entry, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View entryView = inflater.inflate(R.layout.feed_entry, parent, false);
        TextView textView = (TextView)entryView.findViewById(R.id.feed_message);
        ImageView imageView = (ImageView)entryView.findViewById(R.id.feed_image);

        return entryView;
    }
}
