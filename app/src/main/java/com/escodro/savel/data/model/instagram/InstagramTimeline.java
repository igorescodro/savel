
package com.escodro.savel.data.model.instagram;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Timeline entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramTimeline {

    @SerializedName("items")
    private List<InstagramItem> items = null;

    @SerializedName("more_available")
    private Boolean moreAvailable;

    @SerializedName("status")
    private String status;

    @Nullable
    public List<InstagramItem> getItems() {
        return items;
    }
}
