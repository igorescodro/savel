
package com.escodro.savel.data.model.instagram;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the User entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramUser {

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("profile_picture")
    private String profilePicture;

    @SerializedName("username")
    private String username;

    @Nullable
    public String getUsername() {
        return username;
    }

    @Nullable
    public String getProfilePicture() {
        return profilePicture;
    }
}
