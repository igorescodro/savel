package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the ReleaseGroup entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzReleaseGroup {

    @SerializedName("primary-type-id")
    private String primaryTypeId;

    @SerializedName("primary-type")
    private String primaryType;

    @SerializedName("title")
    private String title;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("secondary-type-ids")
    private List<String> secondaryTypeIds = null;

    @SerializedName("first-release-date")
    private String firstReleaseDate;

    @SerializedName("id")
    private String id;

    @SerializedName("secondary-types")
    private List<String> secondaryTypes = null;

    public String getPrimaryTypeId() {
        return primaryTypeId;
    }

    public void setPrimaryTypeId(String primaryTypeId) {
        this.primaryTypeId = primaryTypeId;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    public List<String> getSecondaryTypeIds() {
        return secondaryTypeIds;
    }

    public void setSecondaryTypeIds(List<String> secondaryTypeIds) {
        this.secondaryTypeIds = secondaryTypeIds;
    }

    public String getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(String firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSecondaryTypes() {
        return secondaryTypes;
    }

    public void setSecondaryTypes(List<String> secondaryTypes) {
        this.secondaryTypes = secondaryTypes;
    }

}
