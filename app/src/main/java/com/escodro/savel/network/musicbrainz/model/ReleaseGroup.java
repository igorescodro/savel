package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link ReleaseGroup}.
 */
public class ReleaseGroup {

    /**
     * {link ReleaseGroup} id.
     */
    private String id;

    /**
     * {link ReleaseGroup} primary type.
     */
    @SerializedName("primary-type")
    private String primary_type;

    /**
     * {link ReleaseGroup} title.
     */
    private String title;

    /**
     * {link ReleaseGroup} disambiguation.
     */
    private String disambiguation;

    /**
     * {link ReleaseGroup} relations.
     */
    private String[] relations;

    /**
     * {link ReleaseGroup} secondary types.
     */
    @SerializedName("secondary-types")
    private String[] secondary_types;

    /**
     * {link ReleaseGroup} first release date.
     */
    @SerializedName("first-release-date")
    private String first_release_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimaryType() {
        return primary_type;
    }

    public void setPrimaryType(String primary_type) {
        this.primary_type = primary_type;
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

    public String[] getRelations() {
        return relations;
    }

    public void setRelations(String[] relations) {
        this.relations = relations;
    }

    public String[] getSecondaryTypes() {
        return secondary_types;
    }

    public void setSecondaryTypes(String[] secondary_types) {
        this.secondary_types = secondary_types;
    }

    public String getFirstReleaseDate() {
        return first_release_date;
    }

    public void setFirstReleaseDate(String first_release_date) {
        this.first_release_date = first_release_date;
    }
}
