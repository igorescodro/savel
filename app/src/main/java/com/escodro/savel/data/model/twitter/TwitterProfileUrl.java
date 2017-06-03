
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Profile URL entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterProfileUrl {

    @SerializedName("url")
    private String url;

    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("display_url")
    private String displayUrl;
}
