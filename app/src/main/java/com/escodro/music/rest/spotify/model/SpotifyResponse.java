package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

/**
 * Object to represent an {@link SpotifyAPI} {@link SpotifyResponse}.
 */
public class SpotifyResponse {

    /**
     * {@link SpotifyResponse} artist.
     */
    private Artist artists;

    public Artist getArtists() {
        return artists;
    }

    public void setArtists(Artist artists) {
        this.artists = artists;
    }
}
