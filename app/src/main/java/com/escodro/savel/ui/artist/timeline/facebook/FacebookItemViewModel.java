package com.escodro.savel.ui.artist.timeline.facebook;

import android.view.View;

import com.escodro.savel.data.model.SavelFacebook;
import com.escodro.savel.ui.base.TimelineEntryViewModel;
import com.escodro.savel.util.adapter.DateConverter;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link SavelFacebook} in the view.
 * <p/>
 * Created by Igor Escodro on 15/05/17.
 */
public class FacebookItemViewModel extends TimelineEntryViewModel {

    private SavelFacebook mFacebookItem;

    @Inject
    DateConverter mDateConverter;

    @Inject
    public FacebookItemViewModel() {
    }

    public void setFacebookItem(SavelFacebook facebookItem) {
        mFacebookItem = facebookItem;
    }

    @Override
    protected String getEntryUrl() {
        return mFacebookItem.getPostUrl();
    }

    public String getUsername() {
        return mFacebookItem.getUsername();
    }

    public String getProfilePicture() {
        return mFacebookItem.getProfilePictureUrl();
    }

    public String getCreationTime() {
        return mDateConverter.getRelativeDateTimeString(mFacebookItem.getCreatedTime());
    }

    public String getImage() {
        return mFacebookItem.getMediaPicture();
    }

    public String getMessage() {
        return mFacebookItem.getMessage();
    }

    public int getVideoIconVisibility() {
        return mFacebookItem.isVideo() ? View.VISIBLE : View.GONE;
    }

    public int getMediaImageVisibility() {
        return mFacebookItem.hasMedia() ? View.VISIBLE : View.GONE;
    }

}
