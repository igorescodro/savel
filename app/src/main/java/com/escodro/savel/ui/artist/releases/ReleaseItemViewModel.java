package com.escodro.savel.ui.artist.releases;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;

import com.escodro.savel.data.local.contract.ReleaseItemContract;
import com.escodro.savel.data.model.SavelRelease;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link SavelRelease} in the view.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class ReleaseItemViewModel extends BaseObservable {

    public ObservableField<String> imageUrl;

    private SavelRelease mRelease;

    @Inject
    ReleaseItemContract mContract;

    @Inject
    public ReleaseItemViewModel() {
        imageUrl = new ObservableField<>();
    }

    public void setRelease(SavelRelease release) {
        mRelease = release;
        imageUrl.set(mContract.getCoverArtUrl(release.getId()));
    }

    @Nullable
    public String getTitle() {
        String title = null;
        if (mRelease != null) {
            title = mRelease.getTitle();
        }
        return title;
    }
}
