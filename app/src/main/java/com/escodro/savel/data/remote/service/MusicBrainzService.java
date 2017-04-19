package com.escodro.savel.data.remote.service;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service API containing the methods to communicate with MusicBrainz endpoints.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */

public interface MusicBrainzService {

    @GET("artist/{artistId}?inc=release-groups+url-rels")
    Observable<MusicBrainzArtist> getArtistById(@Path("artistId") String artistId);
}
