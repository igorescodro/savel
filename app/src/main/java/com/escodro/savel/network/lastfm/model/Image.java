package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an {@link LastFmAPI} {@link Image}.
 */
public class Image {

    /**
     * {@link Image} url.
     */
    @SerializedName("#text")
    private String text;

    /**
     * {@link Image} size.
     */
    private String size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
