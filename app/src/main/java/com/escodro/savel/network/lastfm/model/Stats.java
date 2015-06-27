package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

/**
 * Object to represent an {@link LastFmAPI} {@link Stats}.
 */
public class Stats {

    /**
     * {@link Stats} listeners.
     */
    private String listeners;

    /**
     * {@link Stats} play count.
     */
    private String playcount;

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
}
