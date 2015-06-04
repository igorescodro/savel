package com.escodro.music.rest.echonest.model;

import com.escodro.music.rest.echonest.EchoNestAPI;

import java.util.List;

/**
 * Object to represent an {@link EchoNestAPI} {@link Response}.
 */
public class Response {

    /**
     * {@link Response} artists.
     */
    private List<Artist> artists;

    /**
     * {@link Response} status.
     */
    private Status status;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
