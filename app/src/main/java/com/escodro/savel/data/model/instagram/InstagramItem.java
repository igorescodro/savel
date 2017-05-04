
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Item entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramItem {

    @SerializedName("id")
    private String id;

    @SerializedName("code")
    private String code;

    @SerializedName("user")
    private InstagramUser user;

    @SerializedName("images")
    private InstagramImageList images;

    @SerializedName("created_time")
    private String createdTime;

    @SerializedName("caption")
    private InstagramCaption caption;

    @SerializedName("likes")
    private InstagramLike likes;

    @SerializedName("comments")
    private InstagramComments comments;

    @SerializedName("can_view_comments")
    private Boolean canViewComments;

    @SerializedName("can_delete_comments")
    private Boolean canDeleteComments;

    @SerializedName("type")
    private String type;

    @SerializedName("link")
    private String link;

    @SerializedName("location")
    private Object location;

    @SerializedName("alt_media_url")
    private String altMediaUrl;

    @SerializedName("videos")
    private InstagramVideo videos;

    @SerializedName("video_views")
    private Integer videoViews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public InstagramUser getUser() {
        return user;
    }

    public void setUser(InstagramUser user) {
        this.user = user;
    }

    public InstagramImageList getImages() {
        return images;
    }

    public void setImages(InstagramImageList images) {
        this.images = images;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public InstagramCaption getCaption() {
        return caption;
    }

    public void setCaption(InstagramCaption caption) {
        this.caption = caption;
    }

    public InstagramLike getLikes() {
        return likes;
    }

    public void setLikes(InstagramLike likes) {
        this.likes = likes;
    }

    public InstagramComments getComments() {
        return comments;
    }

    public void setComments(InstagramComments comments) {
        this.comments = comments;
    }

    public Boolean getCanViewComments() {
        return canViewComments;
    }

    public void setCanViewComments(Boolean canViewComments) {
        this.canViewComments = canViewComments;
    }

    public Boolean getCanDeleteComments() {
        return canDeleteComments;
    }

    public void setCanDeleteComments(Boolean canDeleteComments) {
        this.canDeleteComments = canDeleteComments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getAltMediaUrl() {
        return altMediaUrl;
    }

    public void setAltMediaUrl(String altMediaUrl) {
        this.altMediaUrl = altMediaUrl;
    }

    public InstagramVideo getVideos() {
        return videos;
    }

    public void setVideos(InstagramVideo videos) {
        this.videos = videos;
    }

    public Integer getVideoViews() {
        return videoViews;
    }

    public void setVideoViews(Integer videoViews) {
        this.videoViews = videoViews;
    }

}
