package com.escodro.savel.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.escodro.savel.data.local.ArtistContract;
import com.escodro.savel.data.model.Artist;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link
 * com.escodro.savel.ui.fragment.ArtistFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistViewModel extends BaseObservable {

    @Inject
    ArtistContract mContract;

    private final ObservableField<Artist> mArtist;

    /**
     * Default injectable constructor to be used in
     * {@link com.escodro.savel.ui.fragment.ArtistFragment}.
     */
    @Inject
    public ArtistViewModel() {
        mArtist = new ObservableField<>();
    }

    /**
     * Load the data related to the {@link Artist} based on it
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService}
     * id.
     *
     * @param artistId artist mbid
     */
    public void loadData(String artistId) {
        final Observable<Artist> artistObservable = mContract.getArtist(artistId);
        artistObservable.subscribe(this::setArtist);
    }

    private void setArtist(Artist artist) {
        mArtist.set(artist);
        notifyChange();
    }

    public Artist getArtist() {
        return mArtist.get();
    }
}
