package com.escodro.savel.data.model;

import android.support.annotation.DrawableRes;

/**
 * Model to represent the fields in the Network Error layout.
 * <p/>
 * Created by Igor Escodro on 28/04/17.
 */
public class NetworkError {

    private final String mTitle;

    private final String mDescription;

    private final int mIconResource;

    public NetworkError(String title, String description, @DrawableRes int iconResource) {
        mTitle = title;
        mDescription = description;
        mIconResource = iconResource;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getIconResource() {
        return mIconResource;
    }

}
