
package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Artist entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifyArtist {

    @SerializedName("external_urls")
    private SpotifyExternalUrls externalUrls;

    @SerializedName("followers")
    private SpotifyFollowers followers;

    @SerializedName("genres")
    private List<String> genres = null;

    @SerializedName("href")
    private String href;

    @SerializedName("id")
    private String id;

    @SerializedName("images")
    private List<SpotifyImage> images = null;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private Integer popularity;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    public SpotifyExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(SpotifyExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public SpotifyFollowers getFollowers() {
        return followers;
    }

    public void setFollowers(SpotifyFollowers followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SpotifyImage> getImages() {
        return images;
    }

    public void setImages(List<SpotifyImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
