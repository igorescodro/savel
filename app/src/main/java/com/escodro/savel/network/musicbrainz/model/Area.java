package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link Area}.
 */
public class Area {

    /**
     * {link Area} id.
     */
    private String id;

    /**
     * {link Area} iso 3166-1 codes.
     */
    private String[] iso_3166_1_codes;

    /**
     * {link Area} disambiguation.
     */
    private String disambiguation;

    /**
     * {link Area} iso 3166-2 codes.
     */
    private String[] iso_3166_2_codes;

    /**
     * {link Area} name.
     */
    private String name;

    /**
     * {link Area} sort name.
     */
    @SerializedName("sort-name")
    private String sort_name;

    /**
     * {link Area} iso 3166-3 codes.
     */
    private String[] iso_3166_3_codes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getIso_3166_1_codes() {
        return iso_3166_1_codes;
    }

    public void setIso_3166_1_codes(String[] iso_3166_1_codes) {
        this.iso_3166_1_codes = iso_3166_1_codes;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    public String[] getIso_3166_2_codes() {
        return iso_3166_2_codes;
    }

    public void setIso_3166_2_codes(String[] iso_3166_2_codes) {
        this.iso_3166_2_codes = iso_3166_2_codes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sort_name;
    }

    public void setSortName(String sort_name) {
        this.sort_name = sort_name;
    }

    public String[] getIso_3166_3_codes() {
        return iso_3166_3_codes;
    }

    public void setIso_3166_3_codes(String[] iso_3166_3_codes) {
        this.iso_3166_3_codes = iso_3166_3_codes;
    }
}
