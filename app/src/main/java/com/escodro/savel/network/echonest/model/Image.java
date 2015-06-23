package com.escodro.savel.network.echonest.model;

import com.escodro.savel.network.echonest.EchoNestAPI;

/**
 * Object to represent an {@link EchoNestAPI} {@link Image}.
 */
public class Image {

    /**
     * {@link Image} tags.
     */
    private String[] tags;

    /**
     * {@link Image} verified.
     */
    private String verified;

    /**
     * {@link Image} license.
     */
    private License license;

    /**
     * {@link Image} url.
     */
    private String url;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
