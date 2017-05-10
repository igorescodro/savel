
package com.escodro.savel.data.model.instagram;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Reolution entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramResolution {

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("url")
    private String url;

    @Nullable
    public String getImageUrl() {
        return url;
    }
}
