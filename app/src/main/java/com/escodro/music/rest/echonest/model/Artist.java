package com.escodro.music.rest.echonest.model;

import java.util.List;

/**
 * Object to represent an {@link com.escodro.music.rest.echonest.EchoNestAPI} {@link Artist}.
 */
public class Artist {

    /**
     * {@link Artist} id.
     */
    private String id;

    /**
     * {@link Artist} name.
     */
    private String name;

    /**
     * {@link Artist} images.
     */
    private List<Image> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
