
package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Followers entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifyFollowers {

    @SerializedName("href")
    private Object href;

    @SerializedName("total")
    private Integer total;

    public Object getHref() {
        return href;
    }

    public void setHref(Object href) {
        this.href = href;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
