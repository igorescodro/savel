package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link MusicBrainzResponse}.
 */
public class MusicBrainzResponse {

    /**
     * {link MusicBrainzResponse} id.
     */
    private String id;

    /**
     * {link MusicBrainzResponse} disambiguation.
     */
    private String disambiguation;

    /**
     * {link MusicBrainzResponse} area.
     */
    private Area area;

    /**
     * {link MusicBrainzResponse} ipis.
     */
    private String[] ipis;

    /**
     * {link MusicBrainzResponse} begin area.
     */
    private Area begin_area;

    /**
     * {link MusicBrainzResponse} relations.
     */
    private List<Relation> relations;

    /**
     * {link MusicBrainzResponse} name.
     */
    private String name;

    /**
     * {link MusicBrainzResponse} sort name.
     */
    @SerializedName("sort-name")
    private String sort_name;

    /**
     * {link MusicBrainzResponse} gender.
     */
    private String gender;

    /**
     * {link MusicBrainzResponse} type.
     */
    private String type;

    /**
     * {link MusicBrainzResponse} release groups.
     */
    @SerializedName("release-groups")
    private List<ReleaseGroup> release_groups;

    /**
     * {link MusicBrainzResponse} life span.
     */
    @SerializedName("life-span")
    private LifeSpan life_span;

    /**
     * {link MusicBrainzResponse} end area.
     */
    private Area end_area;

    /**
     * {link MusicBrainzResponse} country.
     */
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String[] getIpis() {
        return ipis;
    }

    public void setIpis(String[] ipis) {
        this.ipis = ipis;
    }

    public Area getBegin_area() {
        return begin_area;
    }

    public void setBegin_area(Area begin_area) {
        this.begin_area = begin_area;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ReleaseGroup> getReleaseGroups() {
        return release_groups;
    }

    public void setReleaseGroups(List<ReleaseGroup> release_groups) {
        this.release_groups = release_groups;
    }

    public LifeSpan getLifeSpan() {
        return life_span;
    }

    public void setLifeSpan(LifeSpan life_span) {
        this.life_span = life_span;
    }

    public Area getEndArea() {
        return end_area;
    }

    public void setEndArea(Area end_area) {
        this.end_area = end_area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
