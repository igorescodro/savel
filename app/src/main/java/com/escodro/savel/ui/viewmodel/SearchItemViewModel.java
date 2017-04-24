package com.escodro.savel.ui.viewmodel;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.Artist;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link Artist} information to
 * {@link com.escodro.savel.databinding.ItemArtistSearchBinding}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */

public class SearchItemViewModel {

    private Artist mArtist;

    @Inject
    public SearchItemViewModel() {
    }

    public void setArtist(@NonNull Artist artist) {
        mArtist = artist;
    }

    public String getName() {
        return mArtist.getName();
    }
}
