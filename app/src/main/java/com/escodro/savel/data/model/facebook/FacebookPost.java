package com.escodro.savel.data.model.facebook;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Post entity in
 * {@link com.escodro.savel.data.remote.service.FacebookService}.
 */
public class FacebookPost {

    @SerializedName("full_picture")
    private String fullPicture;

    @SerializedName("message")
    private String message;

    @SerializedName("created_time")
    private String createdTime;

    @SerializedName("icon")
    private String icon;

    @SerializedName("permalink_url")
    private String permalinkUrl;

    @SerializedName("from")
    private FacebookUser from;

    @SerializedName("id")
    private String id;

    @SerializedName("source")
    private String source;

    @Nullable
    public String getMediaPicture() {
        return fullPicture;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    @Nullable
    public String getCreatedTime() {
        return createdTime;
    }

    @Nullable
    public String getIcon() {
        return icon;
    }

    @Nullable
    public String getPostUrl() {
        return permalinkUrl;
    }

    @Nullable
    public String getUsername() {
        String username = null;
        if (from != null) {
            username = from.getName();
        }
        return username;
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public String getVideoUrl() {
        return source;
    }
}
