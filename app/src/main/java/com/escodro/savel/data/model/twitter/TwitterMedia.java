
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Media entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterMedia {

    @SerializedName("id")
    private String id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("indices")
    private List<Integer> indices = null;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("media_url_https")
    private String mediaUrlHttps;

    @SerializedName("url")
    private String url;

    @SerializedName("display_url")
    private String displayUrl;

    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("sizes")
    private TwitterSize sizes;
}
