package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

/**
 * Object to represent an {@link SpotifyAPI} {@link Follower}.
 */
public class Follower {

    /**
     * {@link Follower} total.
     */
    private String total;

    /**
     * {@link Follower} href.
     */
    private String href;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
