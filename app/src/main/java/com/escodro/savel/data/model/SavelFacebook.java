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

    private FacebookPost mFacebookItem;

    @Inject
    DateConverter mDateFormatter;

    private String mUserId;

    @Inject
    public SavelFacebook() {
    }

    public void setFacebookItem(@NonNull FacebookPost facebookItem) {
        mFacebookItem = facebookItem;
    }

    @Nullable
    public String getId() {
        String id = null;
        if (mFacebookItem != null) {
            id = mFacebookItem.getId();
        }
        return id;
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mFacebookItem != null && mFacebookItem.getCreatedTime() != null) {
            creationDate = mDateFormatter.timeToMillis(
                    mFacebookItem.getCreatedTime(), FACEBOOK_DATE_FORMAT);
        }
        return creationDate;
    }

    @Nullable
    public String getMediaPicture() {
        String media = null;
        if (mFacebookItem != null) {
            media = mFacebookItem.getMediaPicture();
        }
        return media;
    }

    @Nullable
    public String getMessage() {
        String message = null;
        if (mFacebookItem != null) {
            message = mFacebookItem.getMessage();
        }
        return message;
    }

    @Nullable
    public String getIcon() {
        String icon = null;
        if (mFacebookItem != null) {
            icon = mFacebookItem.getIcon();
        }
        return icon;
    }

    @Nullable
    public String getPostUrl() {
        String postUrl = null;
        if (mFacebookItem != null) {
            postUrl = mFacebookItem.getPostUrl();
        }
        return postUrl;
    }

    @Nullable
    public String getUsername() {
        String username = null;
        if (mFacebookItem != null) {
            username = mFacebookItem.getUsername();
        }
        return username;
    }

    @Nullable
    public String getVideoUrl() {
        String videoUrl = null;
        if (mFacebookItem != null) {
            videoUrl = mFacebookItem.getVideoUrl();
        }
        return videoUrl;
    }

    public boolean isVideo() {
        boolean isVideo = false;
        if (mFacebookItem != null) {
            isVideo = mFacebookItem.getVideoUrl() != null;
        }
        return isVideo;
    }

    public boolean hasMedia() {
        return isVideo() || getMediaPicture() != null;
    }

    public String getProfilePictureUrl() {
        return String.format(BuildConfig.API_FACEBOOK_PROFILE_ENDPOINT, mUserId);
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }
}
