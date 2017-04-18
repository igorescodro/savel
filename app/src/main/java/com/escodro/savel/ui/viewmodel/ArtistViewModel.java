package com.escodro.savel.ui.viewmodel;

import com.escodro.savel.data.model.Artist;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link
 * com.escodro.savel.ui.fragment.ArtistFragment}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistViewModel {

    private final Artist mArtist;

    @Inject
    public ArtistViewModel() {
        mArtist = new Artist();
        mArtist.setName("Name");
        mArtist.setBio("Biography");
    }

    public String getName() {
        return mArtist.getName();
    }

    public String getBio() {
        return mArtist.getBio();
    }
}
