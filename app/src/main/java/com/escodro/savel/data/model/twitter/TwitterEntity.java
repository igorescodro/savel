
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

    public List<TwitterHashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<TwitterHashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    public List<TwitterUserMention> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<TwitterUserMention> userMentions) {
        this.userMentions = userMentions;
    }

    public List<TwitterProfileUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<TwitterProfileUrl> urls) {
        this.urls = urls;
    }

    public List<TwitterMedia> getMedia() {
        return media;
    }

    public void setMedia(List<TwitterMedia> media) {
        this.media = media;
    }

}
