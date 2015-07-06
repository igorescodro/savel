package com.escodro.savel.data;

import com.escodro.savel.network.echonest.model.EchoNestResponse;
import com.escodro.savel.network.lastfm.model.LastFmResponse;
import com.escodro.savel.network.spotify.model.SpotifyResponse;

/**
 * Object to represent an universal compilation of all APIs, containing a reference of each API
 * server response.
 * <p/>
 * Created by IgorEscodro on 03/07/15.
 */
public class Data {

    /**
     * {@link SpotifyResponse} reference.
     */
    private SpotifyResponse spotifyResponse;

    /**
     * {@link EchoNestResponse} reference.
     */
    private EchoNestResponse echoNestResponse;

    /**
     * {@link LastFmResponse} reference.
     */
    private LastFmResponse lastFmResponse;

    public SpotifyResponse getSpotifyResponse() {
        return spotifyResponse;
    }

    public void setSpotifyResponse(
            SpotifyResponse spotifyResponse) {
        this.spotifyResponse = spotifyResponse;
    }

    public EchoNestResponse getEchoNestResponse() {
        return echoNestResponse;
    }

    public void setEchoNestResponse(
            EchoNestResponse echoNestResponse) {
        this.echoNestResponse = echoNestResponse;
    }

    public LastFmResponse getLastFmResponse() {
        return lastFmResponse;
    }

    public void setLastFmResponse(
            LastFmResponse lastFmResponse) {
        this.lastFmResponse = lastFmResponse;
    }
}
