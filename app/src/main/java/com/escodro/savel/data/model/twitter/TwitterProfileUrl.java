
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Profile URL entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterProfileUrl {

    @SerializedName("url")
    private String url;

    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("display_url")
    private String displayUrl;

    @SerializedName("indices")
    private List<Integer> indices = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

}
