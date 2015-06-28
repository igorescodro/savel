package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an {@link LastFmAPI} {@link Link}.
 */
public class Link {

    /**
     * {@link Link} url.
     */
    @SerializedName("#text")
    private String text;

    /**
     * {@link Link} rel.
     */
    private String rel;

    /**
     * {@link Link} href.
     */
    private String href;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
