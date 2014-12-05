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
import com.epita.mti.nuitdelinfoandroid.controller.CampaignController;
import com.epita.mti.nuitdelinfoandroid.controller.ControllerCallback;
import com.epita.mti.nuitdelinfoandroid.design.PaletteTransformation;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Model;
import com.epita.mti.nuitdelinfoandroid.util.DateUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

/**
 * Created by yvan on 12/4/14.
 */
public class CampaignFragment extends Fragment {
    private int mCampaignId;

    public CampaignFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCampaignId = getArguments().getInt("campaign");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_campaign, container, false);

        final TextView tvCampaignName = (TextView)view.findViewById(R.id.campaign_name);
        final TextView tvCampaignDescription = (TextView)view.findViewById(R.id.campaign_description);
        final TextView tvCampaignLocation = (TextView)view.findViewById(R.id.campaign_location);
        final TextView tvCampaignDate = (TextView)view.findViewById(R.id.campaign_date);
        //final TextView tvCampaignVolunteers = (TextView)view.findViewById(R.id.campaign_volunteers);
        final ImageView imgView = (ImageView)view.findViewById(R.id.campaign_logo);


        CampaignController controller = new CampaignController();
        controller.get(mCampaignId, new ControllerCallback<Campaign>() {
            @Override
            public void onResponse(Campaign response) {
                tvCampaignName.setText(response.getName());
                tvCampaignDescription.setText(response.getDescription());
                tvCampaignLocation.setText(response.getLocation());

                StringBuilder sb = new StringBuilder();
                sb.append("Du ");
                sb.append(DateUtil.format(response.getStartDate()));
                sb.append(" au ");
                sb.append(DateUtil.format(response.getStartDate()));

                tvCampaignDate.setText(sb.toString());

                sb = new StringBuilder();
                sb.append("Volontaires souhaités : ");
                sb.append(response.getWantedVolunteers());

                //tvCampaignVolunteers.setText(sb.toString());

                final PaletteTransformation paletteTransformation = PaletteTransformation.instance();
                Picasso.with(imgView.getContext()).load(response.getCharityProfile().getLogoUrl())
                        .fit().centerCrop()
                        .transform(paletteTransformation)
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
            }

            @Override
            public void onError(Exception error) {

            }
        });

        return view;
    }


    private void loadData() {

    }
}
