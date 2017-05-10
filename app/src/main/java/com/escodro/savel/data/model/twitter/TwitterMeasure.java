
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Measure entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterMeasure {

    @SerializedName("w")
    private Integer w;

    @SerializedName("h")
    private Integer h;

    @SerializedName("resize")
    private String resize;
}
