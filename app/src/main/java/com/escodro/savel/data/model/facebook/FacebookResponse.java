package com.escodro.savel.data.model.facebook;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Response entity in
 * {@link com.escodro.savel.data.remote.service.FacebookService}.
 */
public class FacebookResponse {

    @SerializedName("data")
    private List<FacebookPost> data = null;

    @Nullable
    public List<FacebookPost> getData() {
        return data;
    }
}
