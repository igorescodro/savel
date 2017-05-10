package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Caption entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramCaption {

    @SerializedName("id")
    private String id;

    @SerializedName("text")
    private String text;

    @SerializedName("created_time")
    private String createdTime;

    @SerializedName("from")
    private InstagramData from;
}
