package com.epita.mti.nuitdelinfoandroid.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.activity.CampaignActivity;
import com.epita.mti.nuitdelinfoandroid.activity.HomeActivity;
import com.epita.mti.nuitdelinfoandroid.design.PaletteTransformation;
import com.epita.mti.nuitdelinfoandroid.design.RoundedImageView;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.util.DateUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mrollin on 24/10/14.
 */
public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.Holder> {
    private static final String TAG = CampaignAdapter.class.getSimpleName();

    private LayoutInflater mInflater;
    private Activity mActivity;

    private RecyclerView mRecyclerView;
    private List<Campaign> items;

    public CampaignAdapter(Activity activity, List<Campaign> modelData, RecyclerView recyclerView) {
        mActivity = activity;
        if (modelData == null) {
            throw new IllegalArgumentException(
                    "modelData must not be null");
        }
        this.mRecyclerView = recyclerView;
        this.items = modelData;
    }

    @Override
    public Holder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_campaign,
                        viewGroup,
                        false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = mRecyclerView.getChildPosition(v);
                Campaign item = items.get(itemPosition);
                Intent intent = new Intent(mActivity, CampaignActivity.class);
                intent.putExtra("campaign", item.getId());
                mActivity.startActivity(intent);
                Log.d(TAG, item.toString());
            }
        });

        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Holder viewHolder, int position) {
        Campaign model = items.get(position);

        // Populate the item contents
        viewHolder.tvItemName.setText(model.getName());
        viewHolder.tvItemEndDate.setText(DateUtil.timeAgoInWords(model.getInscriptionEndDate()));
        viewHolder.tvItemLocation.setText(model.getLocation());
        final PaletteTransformation paletteTransformation = PaletteTransformation.instance();
        Picasso.with(viewHolder.ivItemLogo.getContext()).load(model.getCharityProfile().getLogoUrl())
                .fit().centerCrop()
                .transform(paletteTransformation)
                .into(viewHolder.ivItemLogo, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable) viewHolder.ivItemLogo.getDrawable()).getBitmap();
                        Palette palette = PaletteTransformation.getPalette(bitmap);

                        viewHolder.ivItemLogo.setBackgroundColor(palette.getVibrantColor(android.R.color.white));
                        viewHolder.ivItemLogo.getBackground().setAlpha(20);
                    }
                });
    }

    /**
     * Will add a new item to our viewModel
     *
     * @param list the list to add
     */
    public void addAll(List<Campaign> list) {
        items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public final static class Holder extends RecyclerView.ViewHolder {
        public ImageView ivItemLogo;
        public TextView tvItemName;
        public TextView tvItemEndDate;
        public TextView tvItemLocation;

        public Holder(View itemView) {
            super(itemView);
            ivItemLogo = (RoundedImageView) itemView.findViewById(R.id.item_logo);
            tvItemName = (TextView) itemView.findViewById(R.id.item_name);
            tvItemEndDate = (TextView) itemView.findViewById(R.id.item_end_date);
            tvItemLocation = (TextView) itemView.findViewById(R.id.item_location);
        }
    }
}