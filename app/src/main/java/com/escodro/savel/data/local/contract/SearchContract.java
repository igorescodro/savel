package com.escodro.savel.data.local.contract;

import com.escodro.savel.data.local.repository.SavelRepository;
import com.escodro.savel.data.model.Artist;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Class containing the contract methods related to
 * {@link com.escodro.savel.ui.viewmodel.SearchViewModel}.
 * <p>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchContract extends BaseContract {

    @Inject
    SavelRepository mSavelRepository;

    @Inject
    public SearchContract() {
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
