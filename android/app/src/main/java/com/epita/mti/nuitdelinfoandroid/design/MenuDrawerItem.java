package com.epita.mti.nuitdelinfoandroid.design;

public class MenuDrawerItem {

    private int mId;
    private String mTitle;
    private int mIcon;

    public MenuDrawerItem(String title, int icon) {
        mId = -1;
        mTitle = title;
        mIcon = icon;
    }

    public MenuDrawerItem(int id, String title, int icon) {
        mId = id;
        mTitle = title;
        mIcon = icon;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }
}

