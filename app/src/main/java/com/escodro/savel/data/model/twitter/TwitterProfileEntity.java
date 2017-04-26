
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Profile entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterProfileEntity {

    @SerializedName("url")
    private TwitterUrlList url;

    @SerializedName("description")
    private TwitterDescription description;

    public TwitterUrlList getUrl() {
        return url;
    }

    public void setUrl(TwitterUrlList url) {
        this.url = url;
    }

    public TwitterDescription getDescription() {
        return description;
    }

    public void setDescription(TwitterDescription description) {
        this.description = description;
    }

}
