package com.escodro.savel.ui.viewmodel;

import android.databinding.ObservableField;

import com.escodro.savel.data.local.contract.ArtistContract;
import com.escodro.savel.data.model.Artist;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link
 * com.escodro.savel.ui.fragment.ArtistFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistViewModel extends NetworkViewModel<Artist> {

    /**
     * {@link ObservableField} to represent the {@link Artist}.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<Artist> artist;

    @Inject
    ArtistContract mContract;

    private String mArtistRequestId;

    /**
     * Default injectable constructor to be used in
     * {@link com.escodro.savel.ui.fragment.ArtistFragment}.
     */
    @Inject
    public ArtistViewModel() {
        artist = new ObservableField<>();
    }

    public void loadArtist(String artistId) {
        mArtistRequestId = artistId;
        loadData();
    }

    @Override
    public Observable<Artist> getObservable() {
        return mContract.getArtist(mArtistRequestId);
    }

    @Override
    public void onResult(Artist result) {
        artist.set(result);
        notifyChange();
    }
}
