package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the BeginArea entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzBeginArea {

    @SerializedName("name")
    private String name;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("sort-name")
    private String sortName;

    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
