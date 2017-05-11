package com.escodro.savel.ui.artist.releases;

import com.escodro.savel.data.model.SavelRelease;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link SavelRelease} in the view.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */

public class ReleaseItemViewModel {
    private SavelRelease mRelease;

    @Inject
    public ReleaseItemViewModel() {
    }

    public void setRelease(SavelRelease release) {
        mRelease = release;
    }

    public String getTitle() {
        return mRelease.getTitle();
    }
}
