package com.escodro.savel.data.local.repository;

import com.escodro.savel.data.model.Artist;
import com.escodro.savel.data.remote.repository.MusicBrainzRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Local repository which wrap the content from every remote service used in the application.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
public class SavelRepository {

    @Inject
    MusicBrainzRepository mMusicBrainzRepository;

    @Inject
    public SavelRepository() {
    }

    /**
     * Get the wrapped {@link Artist} from every music service.
     *
     * @param artistId artist mbid
     * @return artist wrapper
     */
    public Observable<Artist> getArtist(String artistId) {
        return mMusicBrainzRepository.getArtistInfo(artistId).map(
                Artist::new);
    }
}
