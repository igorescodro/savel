package com.escodro.savel.ui.artist.profile;

import android.databinding.ObservableField;

import com.escodro.savel.data.local.database.model.ArtistRealm;
import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.model.SavelArtist;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link SavelArtist} information to {@link ProfileFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class ProfileViewModel {

    public final ObservableField<ArtistRealm> artist;

    /**
     * Default injectable constructor to be used in {@link ProfileFragment}.
     */
    @Inject
    public ProfileViewModel(ArtistProvider provider) {
        artist = new ObservableField<>(provider.retrieveData());
        provider.getObservable().subscribe(artist::set);
    }
}
