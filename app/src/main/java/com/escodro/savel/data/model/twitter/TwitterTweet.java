
package com.escodro.savel.data.model.twitter;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public TwitterEntity getEntities() {
        return entities;
    }

    public void setEntities(TwitterEntity entities) {
        this.entities = entities;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public TwitterUser getUser() {
        return user;
    }

    public void setUser(TwitterUser user) {
        this.user = user;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public Boolean getIsQuoteStatus() {
        return isQuoteStatus;
    }

    public void setIsQuoteStatus(Boolean isQuoteStatus) {
        this.isQuoteStatus = isQuoteStatus;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public TwitterExtendedEntity getExtendedEntities() {
        return extendedEntities;
    }

    public void setExtendedEntities(TwitterExtendedEntity extendedEntities) {
        this.extendedEntities = extendedEntities;
    }

    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

}
