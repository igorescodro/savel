
package com.escodro.savel.data.model.twitter;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the User entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterUser {

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("name")
    private String name;

    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("location")
    private String location;

    @SerializedName("description")
    private String description;

    @SerializedName("url")
    private String url;

    @SerializedName("entities")
    private TwitterProfileEntity entities;

    @SerializedName("protected")
    private Boolean _protected;

    @SerializedName("followers_count")
    private Integer followersCount;

    @SerializedName("friends_count")
    private Integer friendsCount;

    @SerializedName("listed_count")
    private Integer listedCount;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("favourites_count")
    private Integer favouritesCount;

    @SerializedName("utc_offset")
    private Integer utcOffset;

    @SerializedName("time_zone")
    private String timeZone;

    @SerializedName("geo_enabled")
    private Boolean geoEnabled;

    @SerializedName("verified")
    private Boolean verified;

    @SerializedName("statuses_count")
    private Integer statusesCount;

    @SerializedName("lang")
    private String lang;

    @SerializedName("contributors_enabled")
    private Boolean contributorsEnabled;

    @SerializedName("is_translator")
    private Boolean isTranslator;

    @SerializedName("is_translation_enabled")
    private Boolean isTranslationEnabled;

    @SerializedName("profile_background_color")
    private String profileBackgroundColor;

    @SerializedName("profile_background_image_url")
    private String profileBackgroundImageUrl;

    @SerializedName("profile_background_image_url_https")
    private String profileBackgroundImageUrlHttps;

    @SerializedName("profile_background_tile")
    private Boolean profileBackgroundTile;

    @SerializedName("profile_image_url")
    private String profileImageUrl;

    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;

    @SerializedName("profile_banner_url")
    private String profileBannerUrl;

    @SerializedName("profile_link_color")
    private String profileLinkColor;

    @SerializedName("profile_sidebar_border_color")
    private String profileSidebarBorderColor;

    @SerializedName("profile_sidebar_fill_color")
    private String profileSidebarFillColor;

    @SerializedName("profile_text_color")
    private String profileTextColor;

    @SerializedName("profile_use_background_image")
    private Boolean profileUseBackgroundImage;

    @SerializedName("has_extended_profile")
    private Boolean hasExtendedProfile;

    @SerializedName("default_profile")
    private Boolean defaultProfile;

    @SerializedName("default_profile_image")
    private Boolean defaultProfileImage;

    @SerializedName("following")
    private Object following;

    @SerializedName("follow_request_sent")
    private Object followRequestSent;

    @SerializedName("notifications")
    private Object notifications;

    @SerializedName("translator_type")
    private String translatorType;

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getScreenName() {
        return screenName;
    }

    @Nullable
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
