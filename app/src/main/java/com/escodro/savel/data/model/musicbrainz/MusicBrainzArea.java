package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Area entity in {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzArea {

    @SerializedName("name")
    private String name;

    @SerializedName("sort-name")
    private String sortName;

    @SerializedName("iso-3166-1-codes")
    private List<String> iso31661Codes = null;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public List<String> getIso31661Codes() {
        return iso31661Codes;
    }

    public void setIso31661Codes(List<String> iso31661Codes) {
        this.iso31661Codes = iso31661Codes;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
