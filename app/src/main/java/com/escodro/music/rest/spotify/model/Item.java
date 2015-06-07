package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

import java.util.List;

/**
 * Object to represent an {@link SpotifyAPI} {@link Item}. An {@link Item} can be an Artist, an
 * Album, a Track or a Playlist.
 */
public class Item {

    /**
     * {@link Item} id.
     */
    private String id;

    /**
     * {@link Item} followers.
     */
    private Follower followers;

    /**
     * {@link Item} external urls.
     */
    private ExternalUrl external_urls;

    /**
     * {@link Item} genres.
     */
    private String[] genres;

    /**
     * {@link Item} name.
     */
    private String name;

    /**
     * {@link Item} images.
     */
    private List<Image> images;

    /**
     * {@link Item} type.
     */
    private String type;

    /**
     * {@link Item} uri.
     */
    private String uri;

    /**
     * {@link Item} href.
     */
    private String href;

    /**
     * {@link Item} popularity.
     */
    private String popularity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Follower getFollowers() {
        return followers;
    }

    public void setFollowers(Follower followers) {
        this.followers = followers;
    }

    public ExternalUrl getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalUrl external_urls) {
        this.external_urls = external_urls;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}
