package com.escodro.savel.network.musicbrainz;

import com.escodro.savel.network.musicbrainz.model.MusicBrainzResponse;
import com.escodro.savel.requests.CustomCallback;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Interface containing the methods to create requests to MusicBrainz.
 *
 * @see <a href="http://musicbrainz.org/doc/Development/XML_Web_Service/Version_2">MusicBrainz -
 * Development / XML Web Service / Version 2 </a>
 * <p/>
 * Created by IgorEscodro on 09/07/15.
 */
public interface MusicBrainzAPI {

    /**
     * {@link MusicBrainzAPI} request to get all the releases (albums, singles, EPs) and the
     * relations sites (Twitter, Facebook, YouTube etc) from an Artist.
     *
     * @param mbid     {@link MusicBrainzAPI} id
     * @param callback {@link CustomCallback} to be implemented to handle request response
     *
     * @see <a href="http://musicbrainz
     * .org/doc/Development/XML_Web_Service/Version_2#Browse">MusicBrainz
     * - Development / XML Web Service / Version 2 - Browse</a>
     */
    @GET(MusicBrainzClient.PROFILE_URL)
    void getArtistRecordings(@Path("mbid") String mbid,
                             CustomCallback<MusicBrainzResponse> callback);
}
