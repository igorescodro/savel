
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
}
