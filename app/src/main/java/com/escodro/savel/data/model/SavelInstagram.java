package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.util.adapter.DateConverter;

/**
 * Object to represent the {@link com.escodro.savel.data.remote.service.InstagramService} item.
 * The intent of this object is to better encapsulate the fields and contains only relative
 * information.
 * <p/>
 * Created by Igor Escodro on 10/05/17.
 */
public class SavelInstagram {

    private final InstagramItem mInstagramItem;

    public SavelInstagram(@NonNull InstagramItem instagramItem) {
        mInstagramItem = instagramItem;
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mInstagramItem.getCreatedTime() != null) {
            creationDate = DateConverter.unixTimestampToMillis(mInstagramItem.getCreatedTime());
        }
        return creationDate;
    }

    @Nullable
    public String getImageUrl() {
        return mInstagramItem.getImageUrl();
    }

    @Nullable
    public String getUsername() {
        return mInstagramItem.getUsername();
    }

    @Nullable
    public String getProfilePicture() {
        return mInstagramItem.getProfilePicture();
    }

    @Nullable
    public String getType() {
        return mInstagramItem.getType();
    }

    @Nullable
    public String getLink() {
        return mInstagramItem.getLink();
    }
}
