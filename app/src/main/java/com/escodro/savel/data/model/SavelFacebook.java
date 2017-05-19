package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.BuildConfig;
import com.escodro.savel.data.model.facebook.FacebookPost;
import com.escodro.savel.util.adapter.DateConverter;

import javax.inject.Inject;

/**
 * Object to represent the {@link com.escodro.savel.data.remote.service.FacebookService} post.
 * The intent of this object is to better encapsulate the fields and contains only relative
 * information.
 * <p/>
 * Created by Igor Escodro on 15/05/17.
 */
public class SavelFacebook {

    private static final String FACEBOOK_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    private final FacebookPost mFacebookItem;

    private String mUserId;

    @Inject
    public SavelFacebook(@NonNull FacebookPost facebookItem, @NonNull String userId) {
        mFacebookItem = facebookItem;
        mUserId = userId;
    }

    @Nullable
    public String getId() {
        return mFacebookItem.getId();
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mFacebookItem.getCreatedTime() != null) {
            creationDate = DateConverter.timeToMillis(
                    mFacebookItem.getCreatedTime(), FACEBOOK_DATE_FORMAT);
        }
        return creationDate;
    }

    @Nullable
    public String getMediaPicture() {
        return mFacebookItem.getMediaPicture();
    }

    @Nullable
    public String getMessage() {
        return mFacebookItem.getMessage();
    }

    @Nullable
    public String getIcon() {
        return mFacebookItem.getIcon();
    }

    @Nullable
    public String getPostUrl() {
        return mFacebookItem.getPostUrl();
    }

    @Nullable
    public String getUsername() {
        return mFacebookItem.getUsername();
    }

    @Nullable
    public String getVideoUrl() {
        return mFacebookItem.getVideoUrl();
    }

    public boolean isVideo() {
        return mFacebookItem.getVideoUrl() != null;
    }

    public boolean hasMedia() {
        return isVideo() || getMediaPicture() != null;
    }

    public String getProfilePictureUrl() {
        return String.format(BuildConfig.API_FACEBOOK_PROFILE_ENDPOINT, mUserId);
    }
}
