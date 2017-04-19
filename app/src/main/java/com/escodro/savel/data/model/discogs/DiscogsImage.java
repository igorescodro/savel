package com.escodro.savel.data.model.discogs;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Image entity in
 * {@link com.escodro.savel.data.remote.service.DiscogsService}.
 */
public class DiscogsImage {

    @SerializedName("uri")
    private String uri;

    @SerializedName("height")
    private Integer height;

    @SerializedName("width")
    private Integer width;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("uri150")
    private String uri150;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri150() {
        return uri150;
    }

    public void setUri150(String uri150) {
        this.uri150 = uri150;
    }

}
