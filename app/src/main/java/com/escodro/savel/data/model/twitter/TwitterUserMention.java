
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the User Mention entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterUserMention {

    @SerializedName("screen_name")
    private String screenName;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("id_str")
    private String idStr;
}
