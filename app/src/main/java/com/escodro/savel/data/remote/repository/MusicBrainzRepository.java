package com.escodro.savel.data.remote.repository;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtistList;
import com.escodro.savel.data.remote.service.MusicBrainzService;
import com.escodro.savel.injection.qualifier.MusicBrainz;

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
    public MusicBrainzRepository(@MusicBrainz Retrofit retrofit) {
        mService = retrofit.create(MusicBrainzService.class);
    }

    /**
     * Get a {@link MusicBrainzArtist} entity from {@link MusicBrainzService} server.
     *
     * @param artistId artist MBID
     *
     * @return observable of MusicBrainz Artist entity
     */
    public Observable<MusicBrainzArtist> getArtistInfo(String artistId) {
        return mService.getArtistById(artistId).retry();
    }

    /**
     * Get a {@link MusicBrainzArtistList} entity from {@link MusicBrainzService} server.<br>
     * This method refactor the given parameter to fit the API endpoint, following the given
     * example:
     * <p>
     * <code>
     * artist/?query=artist:fred%20AND%20type:group%20AND%20country:US
     * </code>
     *
     * @param artistName artist name
     *
     * @return observable of MusicBrainz Artist List entity
     */
    public Observable<MusicBrainzArtistList> searchArtist(String artistName) {
        return mService.searchArtist(artistName).retry();
    }
}
