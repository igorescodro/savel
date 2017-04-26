package com.escodro.savel.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.escodro.savel.data.local.contract.ArtistContract;
import com.escodro.savel.data.model.Artist;

import javax.inject.Inject;

import io.reactivex.Observable;
import timber.log.Timber;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link
 * com.escodro.savel.ui.fragment.ArtistFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistViewModel extends BaseObservable {

    /**
     * {@link ObservableField} to represent if the network error screen should be show.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<Integer> networkErrorVisibility;

    /**
     * {@link ObservableField} to represent if the loading screen should be show.
     * <h1>This attribute must only be used to Data Binding.</h1>
     */
    public final ObservableField<Integer> loadingVisibility;

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
        networkErrorVisibility = new ObservableField<>(View.INVISIBLE);
        loadingVisibility = new ObservableField<>(View.INVISIBLE);
    }

    /**
     * Load the data related to the {@link Artist} based on it
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService}
     * id.
     *
     * @param artistId artist MBID
     */
    public void loadData(String artistId) {
        loadingVisibility.set(View.VISIBLE);
        networkErrorVisibility.set(View.INVISIBLE);
        mArtistRequestId = artistId;
        final Observable<Artist> artistObservable = mContract.getArtist(artistId);
        artistObservable.subscribe(this::setArtist, this::handleError);
    }

    private void setArtist(Artist value) {
        loadingVisibility.set(View.INVISIBLE);
        networkErrorVisibility.set(View.INVISIBLE);
        artist.set(value);
        notifyChange();
    }

    private void handleError(Throwable throwable) {
        loadingVisibility.set(View.INVISIBLE);
        networkErrorVisibility.set(View.VISIBLE);
        Timber.e(throwable.getMessage(), throwable);
    }

    /**
     * Returns the default action when user clicks in the "Retry" button after showing network
     * error screen.
     *
     * @return onClickListener to reload artist
     */
    public View.OnClickListener getRetryClickListener() {
        return view -> loadData(mArtistRequestId);
    }
}
