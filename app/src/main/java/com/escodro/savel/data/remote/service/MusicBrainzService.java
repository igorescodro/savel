package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtistList;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroupList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
     * Connect to artist endpoints and retrieve a {@link MusicBrainzArtist} based on the MBID.
     *
     * @param artistId artist MBID
     *
     * @return observable of MusicBrainz artist
     *
     * @see
     * <a href="https://musicbrainz.org/doc/Development/XML_Web_Service/Version_2/Search#Artist">MusicBrainz
     * API Documentation | Artists</a>
     */
    @GET("artist/{artistId}?inc=url-rels")
    Observable<MusicBrainzArtist> getArtistById(@Path("artistId") String artistId);

    /**
     * Connect to release group endpoint and retrieve a {@link MusicBrainzReleaseGroupList} based
     * on the Artist MBID. The results from this endpoint is more complete than linked with the
     * {@link MusicBrainzService#getArtistById(String)} via "<code>inc=</code>".
     *
     * @param artistId artist MBID
     *
     * @return observable of MusicBrainz release group
     *
     * @see
     * <a href="https://musicbrainz.org/doc/Development/XML_Web_Service/Version_2/Search#Release_Group">MusicBrainz
     * API Documentation | Release Group</a>
     */
    @GET("release-group?limit=100")
    Observable<MusicBrainzReleaseGroupList> getReleaseGroupByArtistId(
            @Query("artist") String artistId);

    /**
     * Connect to artist search endpoint and retrieve a {@link MusicBrainzArtistList} based on its
     * name.
     *
     * @param artistName artist name
     *
     * @return observable of MusicBrainz artist list
     *
     * @see
     * <a href="https://musicbrainz.org/doc/Development/XML_Web_Service/Version_2/Search#Artist">MusicBrainz
     * API Documentation | Artists</a>
     */
    @GET("artist")
    Observable<MusicBrainzArtistList> searchArtist(@Query("query") String artistName);
}
