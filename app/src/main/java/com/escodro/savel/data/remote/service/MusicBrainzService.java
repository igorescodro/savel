package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with MusicBrainz endpoints.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 *
 * @see <a href="https://musicbrainz.org/doc/Development/XML_Web_Service/Version_2">MusicBrainz API
 * Documentation</a>
 */
public interface MusicBrainzService {

    /**
     * Connect to artist endpoints and retrieve an {@link MusicBrainzArtist} based on the MBID.
     *
     * @param artistId artist MBID
     * @return observable of MusicBrainz artist
     * @see
     * <a href="https://musicbrainz.org/doc/Development/XML_Web_Service/Version_2/Search#Artist">MusicBrainz
     * API Documentation | Artists</a>
     */
    @GET("artist/{artistId}?inc=release-groups+url-rels")
    Observable<MusicBrainzArtist> getArtistById(@Path("artistId") String artistId);
}
