package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

import java.util.List;

/**
 * Object to represent an {@link LastFmAPI} {@link Artist}.
 */
public class Artist {

    /**
     * {@link Artist} tags.
     */
    private Tags tags;

    /**
     * {@link Artist} on tour.
     */
    private String ontour;

    /**
     * {@link Artist} MusicBrainz ID.
     */
    private String mbid;

    /**
     * {@link Artist} bio.
     */
    private Bio bio;

    /**
     * {@link Artist} stats.
     */
    private Stats stats;

    /**
     * {@link Artist} name.
     */
    private String name;

    /**
     * {@link Artist} streamble.
     */
    private String streamable;

    /**
     * {@link Artist} images.
     */
    private List<Image> image;

    /**
     * {@link Artist} url.
     */
    private String url;

    /**
     * {@link Artist} similar.
     */
    private Similar similar;

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getOntour() {
        return ontour;
    }

    public void setOntour(String ontour) {
        this.ontour = ontour;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public Bio getBio() {
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Similar getSimilar() {
        return similar;
    }

    public void setSimilar(Similar similar) {
        this.similar = similar;
    }
}
