package com.escodro.music.rest.echonest.model;

/**
 * Object to represent an {@link com.escodro.music.rest.echonest.EchoNestAPI} {@link License}.
 */
public class License {

    /**
     * {@link License} type.
     */
    private String type;

    /**
     * {@link License} url.
     */
    private String url;

    /**
     * {@link License} attribution.
     */
    private String attribution;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }
}
