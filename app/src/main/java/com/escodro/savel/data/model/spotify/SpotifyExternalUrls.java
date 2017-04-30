
package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the External URLs entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifyExternalUrls {

    @SerializedName("spotify")
    private String spotify;

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

}
