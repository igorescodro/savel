package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.remote.service.MusicBrainzService;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link MusicBrainzService}.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
public class MusicBrainzRepository {

    private final MusicBrainzService mService;

    @Inject
    public MusicBrainzRepository(Retrofit retrofit) {
        mService = retrofit.create(MusicBrainzService.class);
    }

    /**
     * Get a {@link MusicBrainzArtist} entity from {@link MusicBrainzService} server.
     *
     * @param artistId artist mbid
     * @return observable of MusicBrainz Artist entity
     */
    public Observable<MusicBrainzArtist> getArtistInfo(String artistId) {
        return mService.getArtistById(artistId);
    }
}
