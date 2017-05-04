
package com.escodro.savel.data.model.instagram;

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

    public List<InstagramItem> getItems() {
        return items;
    }

    public void setItems(List<InstagramItem> items) {
        this.items = items;
    }

    public Boolean getMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(Boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
