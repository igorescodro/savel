package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.util.adapter.DateConverter;

import javax.inject.Inject;

/**
 * Object to represent the {@link com.escodro.savel.data.remote.service.InstagramService} item.
 * The intent of this object is to better encapsulate the fields and contains only relative
 * information.
 * <p/>
 * Created by Igor Escodro on 10/05/17.
 */
public class SavelInstagram {

    private InstagramItem mInstagramItem;

    @Inject
    DateConverter mDateFormatter;

    @Inject
    public SavelInstagram() {
    }

    public void setInstagramItem(@NonNull InstagramItem instagramItem) {
        mInstagramItem = instagramItem;
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mInstagramItem != null && mInstagramItem.getCreatedTime() != null) {
            creationDate = mDateFormatter.unixTimestampToMillis(mInstagramItem.getCreatedTime());
        }
        return creationDate;
    }

    @Nullable
    public String getImageUrl() {
        String imageUrl = null;
        if (mInstagramItem != null) {
            imageUrl = mInstagramItem.getImageUrl();
        }
        return imageUrl;
    }

    @Nullable
    public String getUsername() {
        String username = null;
        if (mInstagramItem != null) {
            username = mInstagramItem.getUsername();
        }
        return username;
    }

    @Nullable
    public String getProfilePicture() {
        String profilePic = null;
        if (mInstagramItem != null) {
            profilePic = mInstagramItem.getProfilePicture();
        }
        return profilePic;
    }

    @Nullable
    public String getType() {
        String type = null;
        if (mInstagramItem != null) {
            type = mInstagramItem.getType();
        }
        return type;
    }

    @Nullable
    public String getLink() {
        String type = null;
        if (mInstagramItem != null) {
            type = mInstagramItem.getLink();
        }
        return type;
    }
}
