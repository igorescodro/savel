package com.escodro.savel.network.echonest.model;

import com.escodro.savel.network.echonest.EchoNestAPI;

/**
 * Object to represent an {@link EchoNestAPI} {@link Response}.
 */
public class Response {

    /**
     * {@link Response} artists.
     */
    private Artist artist;

    /**
     * {@link Response} status.
     */
    private Status status;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artists) {
        this.artist = artists;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
