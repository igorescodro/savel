
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Like entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramLike {

    @SerializedName("data")
    private List<InstagramData> data = null;

    @SerializedName("count")
    private Integer count;
}
