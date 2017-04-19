package com.escodro.savel.data.model.discogs;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Member entity in
 * {@link com.escodro.savel.data.remote.service.DiscogsService}.
 */
public class DiscogsMember {

    @SerializedName("active")
    private Boolean active;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
