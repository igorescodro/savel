package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

import java.util.List;

/**
 * Object to represent an {@link LastFmAPI} {@link Similar}.
 */
public class Similar {

    /**
     * {@link Similar} artists.
     */
    private List<Artist> artist;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }
}
