package com.epita.mti.nuitdelinfoandroid.design;

/**
 * Created by mrollin on 04/12/14.
 */
public class MenuDrawerItem {

    private String mTitle;
    private int mIcon;

    public MenuDrawerItem() {
    }

    public MenuDrawerItem(String title, int icon) {
        mTitle = title;
        mIcon = icon;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }
}

