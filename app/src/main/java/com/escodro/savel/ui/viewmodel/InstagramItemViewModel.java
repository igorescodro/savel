package com.escodro.savel.ui.viewmodel;

import com.escodro.savel.data.model.instagram.InstagramItem;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link InstagramItem} in the view.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class InstagramItemViewModel {

    private InstagramItem mInstagramItem;

    @Inject
    public InstagramItemViewModel() {
    }

    public void setInstagramItem(InstagramItem instagramItem) {
        mInstagramItem = instagramItem;
    }

    public String getImage() {
        return mInstagramItem.getImages().getStandardResolution().getUrl();
    }

    public String getUsername() {
        return mInstagramItem.getUser().getUsername();
    }

    public String getProfilePicture() {
        return mInstagramItem.getUser().getProfilePicture();
    }
}
