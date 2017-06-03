
package com.escodro.savel.data.model.twitter;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Media entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterMedia {

    private static final String TYPE_VIDEO = "video";

    private static final String TYPE_GIF = "animated_gif";

    @SerializedName("id")
    private String id;

    @SerializedName("id_str")
    private String idStr;

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

    public String getMediaThumbnail() {
        return mediaUrl;
    }

    public boolean isPlayable() {
        return TextUtils.equals(type, TYPE_VIDEO) || TextUtils.equals(type, TYPE_GIF);
    }
}
