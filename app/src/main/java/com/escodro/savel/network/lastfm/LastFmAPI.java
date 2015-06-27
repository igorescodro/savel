package com.escodro.savel.network.lastfm;

import com.escodro.savel.network.lastfm.model.Artist;
import com.escodro.savel.network.lastfm.model.LastFmResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface containing the methods to create requests to LastFM.
 *
 * @see <a href="http://www.lastfm.com.br/api/intro">Last.fm Web Services</a>
 * <p/>
 * Created by IgorEscodro on 27/06/15.
 */
public interface LastFmAPI {

    /**
     * {@link LastFmAPI} request to get information about an {@link Artist} by the MusicBrainz ID.
     *
     * @param mbid     MusicBrainz ID
     * @param callback {@link Callback} to be implemented to handle request response
     *
     * @see <a href="http://www.lastfm.com.br/api/show/album.getInfo">Last.fm Web Services -
     * album.getInfo</a>
     */
    @GET(LastFmClient.PROFILE_URL)
    void getArtistInfoByMBID(@Query("mbid") String mbid, Callback<LastFmResponse> callback);
}
