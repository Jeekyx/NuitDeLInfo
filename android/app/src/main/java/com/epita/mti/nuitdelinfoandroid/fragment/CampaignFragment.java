package com.epita.mti.nuitdelinfoandroid.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.design.PaletteTransformation;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

/**
 * Created by yvan on 12/4/14.
 */
public class CampaignFragment extends Fragment {
    private Campaign mCampaign;

    public CampaignFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int campaignId = getArguments().getInt("campaign");
        mCampaign = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_campaign, container, false);

        final TextView tvCampaignName = (TextView)view.findViewById(R.id.campaign_name);
        tvCampaignName.setText("campaign");

        final TextView tvCampaignDescription = (TextView)view.findViewById(R.id.campaign_description);
        tvCampaignName.setText("campaign");

        final TextView tvCampaignLocation = (TextView)view.findViewById(R.id.campaign_location);
        tvCampaignName.setText("campaign");

        final TextView tvCampaignDate = (TextView)view.findViewById(R.id.campaign_date);
        tvCampaignName.setText("campaign");

        final TextView tvCampaignSub = (TextView)view.findViewById(R.id.campaign_subscription_date);
        tvCampaignName.setText("campaign");

        final TextView tvCampaignVolunteers = (TextView)view.findViewById(R.id.campaign_volunteers);
        tvCampaignName.setText("campaign");

        final ImageView imgView = (ImageView)view.findViewById(R.id.campaign_logo);

        String url = "";
        /*
        final PaletteTransformation paletteTransformation = PaletteTransformation.instance();
        Picasso.with(imgView.getContext()).load(url)
                .fit().centerCrop()
                .transform(paletteTransformation)
                        //.skipMemoryCache()
                .into(imgView, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                        Palette palette = PaletteTransformation.getPalette(bitmap);

                        imgView.setBackgroundColor(palette.getVibrantColor(android.R.color.white));
                        if (isAdded())
                            imgView.getBackground().setAlpha(getActivity().getResources().getInteger(R.integer.picasso_alpha));
                    }
                });
        */
        return view;
    }


    private void loadData() {

    }
}
