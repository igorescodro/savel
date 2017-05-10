
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterEntity {

    @SerializedName("hashtags")
    private List<TwitterHashtag> hashtags = null;

    @SerializedName("symbols")
    private List<String> symbols = null;

    @SerializedName("user_mentions")
    private List<TwitterUserMention> userMentions = null;

    @SerializedName("urls")
    private List<TwitterProfileUrl> urls = null;

    @SerializedName("media")
    private List<TwitterMedia> media = null;
}
