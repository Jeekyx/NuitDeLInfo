package com.epita.mti.nuitdelinfoandroid.controller;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.epita.mti.nuitdelinfoandroid.app.AppController;
import com.epita.mti.nuitdelinfoandroid.model.Model;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequest;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequestCallback;
import com.fasterxml.jackson.databind.JavaType;

public abstract class Controller<T extends Model> {
    /**
     * The TAG for logs
     */
    private static final String TAG = Controller.class.getSimpleName();

    protected String mTableName;

    /**
     * Return an entity using its id.
     */
    protected void get(final Class modelClass, final int id, final ControllerCallback callback) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(mTableName);
        sb.append("/");
        sb.append(id);

        AppController.getInstance().addToRequestQueue(new JacksonRequest<>(Request.Method.GET, sb.toString(), new JacksonRequestCallback<T>() {
            @Override
            public void onResponse(T response, int statusCode, VolleyError error) {
                if (error != null)
                    callback.onError(error);
                else
                    callback.onResponse(response);
            }

            @Override
            public JavaType getReturnType() {
                return JacksonRequest.getObjectMapper().getTypeFactory().constructType(modelClass);
            }
        }));
    }

    /**
     * Return all the entities.
     */
    protected void getAll(final Class modelClass, final ControllerCallback callback) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(mTableName);

        AppController.getInstance().addToRequestQueue(new JacksonRequest<>(Request.Method.GET, sb.toString(), new JacksonRequestCallback<T>() {
            @Override
            public void onResponse(T response, int statusCode, VolleyError error) {
                if (error != null)
                    callback.onError(error);
                else
                    callback.onResponse(response);
            }

            @Override
            public JavaType getReturnType() {
                return JacksonRequest.getObjectMapper().getTypeFactory().constructType(modelClass);
            }
        }));
    }
}
