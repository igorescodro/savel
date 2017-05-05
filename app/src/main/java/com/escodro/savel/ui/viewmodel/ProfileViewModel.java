package com.escodro.savel.ui.viewmodel;

import android.databinding.ObservableField;

import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.ui.fragment.ProfileFragment;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link ProfileFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class ProfileViewModel {

    public final ObservableField<Artist> artist;

    /**
     * Default injectable constructor to be used in
     * {@link ProfileFragment}.
     */
    @Inject
    public ProfileViewModel(ArtistProvider provider) {
        artist = new ObservableField<>(provider.retrieveData());
        provider.getObservable().subscribe(artist::set);
    }
}
