package com.escodro.savel.data.model.facebook;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the User entity in
 * {@link com.escodro.savel.data.remote.service.FacebookService}.
 */
public class FacebookUser {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @Nullable
    public String getName() {
        return name;
    }
}
