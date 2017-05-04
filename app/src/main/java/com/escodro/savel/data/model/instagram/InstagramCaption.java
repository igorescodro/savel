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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public InstagramData getFrom() {
        return from;
    }

    public void setFrom(InstagramData from) {
        this.from = from;
    }

}
