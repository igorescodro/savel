package com.escodro.savel.data.local.contract;

import com.escodro.savel.data.local.repository.SavelRepository;
import com.escodro.savel.data.model.Artist;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Class containing the contract methods related to
 * {@link com.escodro.savel.ui.viewmodel.ArtistViewModel}.
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

    /**
     * Search the artist from the {@link SavelRepository} and apply the {@link
     * io.reactivex.Scheduler}s.
     *
     * @param artistName artist name
     *
     * @return observable of artist list
     */
    public Observable<List<Artist>> searchArtist(String artistName) {
        return mSavelRepository.searchArtist(artistName).compose(applySchedulers());
    }
}
