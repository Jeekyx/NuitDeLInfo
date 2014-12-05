package com.epita.mti.nuitdelinfoandroid.controller;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.epita.mti.nuitdelinfoandroid.app.AppController;
import com.epita.mti.nuitdelinfoandroid.model.TinyTubeModel;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequest;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequestCallback;
import com.fasterxml.jackson.databind.JavaType;

/**
 * Created by _Gary_ on 28/11/2014.
 */
public class TinyTubeController extends Controller<TinyTubeModel> {
    public void search(final ControllerCallback callback) {
        AppController.getInstance().addToRequestQueue(new JacksonRequest<>(Request.Method.GET, "/youtube_api_search.json", new JacksonRequestCallback<TinyTubeModel>() {
            @Override
            public void onResponse(TinyTubeModel response, int statusCode, VolleyError error) {
                if (error != null)
                    callback.onError(error);
                else
                    callback.onResponse(response);
            }

            @Override
            public JavaType getReturnType() {
                return JacksonRequest.getObjectMapper().getTypeFactory().constructType(TinyTubeModel.class);
            }
        }));
    }
}
