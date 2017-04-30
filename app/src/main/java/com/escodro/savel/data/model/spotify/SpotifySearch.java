package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Search entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifySearch {

    @SerializedName("artists")
    private SpotifyArtistList artists;

    public SpotifyArtistList getArtists() {
        return artists;
    }

    public void setArtists(SpotifyArtistList artists) {
        this.artists = artists;
    }

}
