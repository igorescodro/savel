package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Url entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzUrl {

    @SerializedName("id")
    private String id;

    @SerializedName("resource")
    private String resource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

}
