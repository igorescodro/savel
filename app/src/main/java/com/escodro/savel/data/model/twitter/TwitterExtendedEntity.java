
package com.escodro.savel.data.model.twitter;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Extended Entity entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterExtendedEntity {

    @SerializedName("media")
    private List<TwitterMedia> media;

    public boolean isPlayable() {
        boolean isPlayable = false;
        if (media != null && !media.isEmpty()) {
            isPlayable = media.get(0).isPlayable();
        }
        return isPlayable;
    }

    @Nullable
    public String getMediaThumbnail() {
        String thumbnail = null;
        if (media != null && !media.isEmpty()) {
            thumbnail = media.get(0).getMediaThumbnail();
        }
        return thumbnail;
    }
}
