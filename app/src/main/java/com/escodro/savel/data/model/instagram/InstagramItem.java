
package com.escodro.savel.data.model.instagram;

import android.support.annotation.Nullable;

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

    @Nullable
    public String getCreatedTime() {
        return createdTime;
    }

    @Nullable
    public String getImageUrl() {
        String imageUrl = null;
        if (images != null) {
            imageUrl = images.getImageUrl();
        }
        return imageUrl;
    }

    @Nullable
    public String getUsername() {
        String username = null;
        if (user != null) {
            username = user.getUsername();
        }
        return username;
    }

    @Nullable
    public String getProfilePicture() {
        String profilePic = null;
        if (user != null) {
            profilePic = user.getProfilePicture();
        }
        return profilePic;
    }

    @Nullable
    public String getType() {
        return type;
    }

    @Nullable
    public String getLink() {
        return link;
    }
}
