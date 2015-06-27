package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

import java.util.List;

/**
 * Object to represent an {@link LastFmAPI} {@link Tags}.
 */
public class Tags {

    /**
     * {@link Tags} tag.
     */
    private List<Tag> tag;

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }
}
