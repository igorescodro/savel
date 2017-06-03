
package com.escodro.savel.data.model.instagram;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Image List entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramImageList {

    @SerializedName("thumbnail")
    private InstagramResolution thumbnail;

    @SerializedName("low_resolution")
    private InstagramResolution lowResolution;

    @SerializedName("standard_resolution")
    private InstagramResolution standardResolution;

    @Nullable
    public String getImageUrl() {
        String imageUrl = null;
        if (standardResolution != null) {
            imageUrl = standardResolution.getImageUrl();
        }
        return imageUrl;
    }
}
