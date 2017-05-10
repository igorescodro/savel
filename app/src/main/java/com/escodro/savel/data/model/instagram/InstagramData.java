
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Data entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramData {

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("profile_picture")
    private String profilePicture;
    
    @SerializedName("username")
    private String username;
}
