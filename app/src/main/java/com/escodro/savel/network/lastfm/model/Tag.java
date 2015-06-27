package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

/**
 * Object to represent an {@link LastFmAPI} {@link Tag}.
 */
public class Tag {

    /**
     * {@link Tag} name.
     */
    private String name;

    /**
     * {@link Tag} url.
     */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
