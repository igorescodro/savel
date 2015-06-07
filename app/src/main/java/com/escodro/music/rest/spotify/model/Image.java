package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

/**
 * Object to represent an {@link SpotifyAPI} {@link Image}.
 */
public class Image {
    /**
     * {@link Image} height.
     */
    private String height;

    /**
     * {@link Image} width.
     */
    private String width;

    /**
     * {@link Image} url.
     */
    private String url;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
