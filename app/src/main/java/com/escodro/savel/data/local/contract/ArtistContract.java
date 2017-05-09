package com.escodro.savel.data.local.contract;

import com.escodro.savel.data.local.repository.SavelRepository;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.ui.artist.ArtistViewModel;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Class containing the contract methods related to {@link ArtistViewModel}.
 * <p>
 * Created by Igor Escodro on 18/04/17.
 */
public class ArtistContract extends BaseContract {

    @Inject
    SavelRepository mSavelRepository;

    @Inject
    public ArtistContract() {
    }

    /**
     * Get the artist from the {@link SavelRepository} and apply the {@link
     * io.reactivex.Scheduler}s.
     *
     * @param artistId artist MBID
     *
     * @return observable of artist
     */
    public Observable<Artist> getArtist(String artistId) {
        return mSavelRepository.getArtist(artistId).compose(applySchedulers());
    }
}
