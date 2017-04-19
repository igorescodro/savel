package com.escodro.savel.data.model.discogs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Artist entity in
 * {@link com.escodro.savel.data.remote.service.DiscogsService}.
 */
public class DiscogsArtist {

    @SerializedName("profile")
    private String profile;

    @SerializedName("releases_url")
    private String releasesUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("uri")
    private String uri;

    @SerializedName("members")
    private List<DiscogsMember> members = null;

    @SerializedName("urls")
    private List<String> urls = null;

    @SerializedName("images")
    private List<DiscogsImage> images = null;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("aliases")
    private List<DiscogsAlias> aliases = null;

    @SerializedName("id")
    private Integer id;

    @SerializedName("data_quality")
    private String dataQuality;

    @SerializedName("namevariations")
    private List<String> namevariations = null;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<DiscogsMember> getMembers() {
        return members;
    }

    public void setMembers(List<DiscogsMember> members) {
        this.members = members;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<DiscogsImage> getImages() {
        return images;
    }

    public void setImages(List<DiscogsImage> images) {
        this.images = images;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public List<DiscogsAlias> getAliases() {
        return aliases;
    }

    public void setAliases(List<DiscogsAlias> aliases) {
        this.aliases = aliases;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public List<String> getNamevariations() {
        return namevariations;
    }

    public void setNamevariations(List<String> namevariations) {
        this.namevariations = namevariations;
    }

}
