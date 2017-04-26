
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Extended Entity entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterExtendedEntity {

    @SerializedName("media")
    private List<TwitterMedia> media = null;

    public List<TwitterMedia> getMedia() {
        return media;
    }

    public void setMedia(List<TwitterMedia> media) {
        this.media = media;
    }

}
