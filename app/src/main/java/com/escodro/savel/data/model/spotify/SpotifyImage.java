
package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Image entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifyImage {

    @SerializedName("height")
    private Integer height;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
