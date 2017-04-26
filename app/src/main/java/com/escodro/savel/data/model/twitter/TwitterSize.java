
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Size entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterSize {

    @SerializedName("medium")
    private TwitterMeasure medium;

    @SerializedName("thumb")
    private TwitterMeasure thumb;

    @SerializedName("large")
    private TwitterMeasure large;

    @SerializedName("small")
    private TwitterMeasure small;

    public TwitterMeasure getMedium() {
        return medium;
    }

    public void setMedium(TwitterMeasure medium) {
        this.medium = medium;
    }

    public TwitterMeasure getThumb() {
        return thumb;
    }

    public void setThumb(TwitterMeasure thumb) {
        this.thumb = thumb;
    }

    public TwitterMeasure getLarge() {
        return large;
    }

    public void setLarge(TwitterMeasure large) {
        this.large = large;
    }

    public TwitterMeasure getSmall() {
        return small;
    }

    public void setSmall(TwitterMeasure small) {
        this.small = small;
    }

}
