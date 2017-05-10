
package com.escodro.savel.data.model.twitter;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Tweet entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterTweet {

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private String id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("text")
    private String text;

    @SerializedName("truncated")
    private Boolean truncated;

    @SerializedName("entities")
    private TwitterEntity entities;

    @SerializedName("source")
    private String source;

    @SerializedName("in_reply_to_status_id")
    private Object inReplyToStatusId;

    @SerializedName("in_reply_to_status_id_str")
    private Object inReplyToStatusIdStr;

    @SerializedName("in_reply_to_user_id")
    private Object inReplyToUserId;

    @SerializedName("in_reply_to_user_id_str")
    private Object inReplyToUserIdStr;

    @SerializedName("in_reply_to_screen_name")
    private Object inReplyToScreenName;

    @SerializedName("user")
    private TwitterUser user;

    @SerializedName("geo")
    private Object geo;

    @SerializedName("coordinates")
    private Object coordinates;

    @SerializedName("place")
    private Object place;

    @SerializedName("contributors")
    private Object contributors;

    @SerializedName("is_quote_status")
    private Boolean isQuoteStatus;

    @SerializedName("retweet_count")
    private Integer retweetCount;

    @SerializedName("favorite_count")
    private Integer favoriteCount;

    @SerializedName("favorited")
    private Boolean favorited;

    @SerializedName("retweeted")
    private Boolean retweeted;

    @SerializedName("lang")
    private String lang;

    @SerializedName("extended_entities")
    private TwitterExtendedEntity extendedEntities;

    @SerializedName("possibly_sensitive")
    private Boolean possiblySensitive;

    @Nullable
    public String getCreatedAt() {
        return createdAt;
    }

    @Nullable
    public String getId() {
        return idStr;
    }

    @Nullable
    public String getUserName() {
        String username = null;
        if (user != null) {
            username = user.getName();
        }
        return username;
    }

    @Nullable
    public String getScreenName() {
        String screenName = null;
        if (user != null) {
            screenName = user.getScreenName();
        }
        return screenName;
    }

    @Nullable
    public String getProfileImageUrl() {
        String profilePicture = null;
        if (user != null) {
            profilePicture = user.getProfileImageUrl();
        }
        return profilePicture;
    }

    @Nullable
    public String getText() {
        return text;
    }
}
