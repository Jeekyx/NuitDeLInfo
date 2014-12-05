package com.epita.mti.nuitdelinfoandroid.model;

/**
 * Created by _Gary_ on 28/11/2014.
 * Abstract model
 */
public abstract class Model {
    /**
     * The TAG for logs
     */
    private static final String TAG = Model.class.getSimpleName();

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
