package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

/**
 * Object to represent an {@link SpotifyAPI} {@link ExternalUrl}.
 */
public class ExternalUrl {

    /**
     * {@link ExternalUrl} spotify.
     */
    private String spotify;

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
