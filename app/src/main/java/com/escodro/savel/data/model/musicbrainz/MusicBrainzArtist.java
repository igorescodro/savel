package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Artist entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzArtist {

    @SerializedName("release-groups")
    private List<MusicBrainzReleaseGroup> releaseGroups = null;

    @SerializedName("isnis")
    private List<String> isnis = null;

    @SerializedName("area")
    private MusicBrainzArea area;

    @SerializedName("life-span")
    private MusicBrainzLifeSpan lifeSpan;

    @SerializedName("ipis")
    private List<String> ipis = null;

    @SerializedName("begin_area")
    private MusicBrainzBeginArea beginArea;

    @SerializedName("id")
    private String id;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("gender-id")
    private String genderId;

    @SerializedName("country")
    private String country;

    @SerializedName("sort-name")
    private String sortName;

    @SerializedName("type")
    private String type;

    @SerializedName("end_area")
    private Object endArea;

    @SerializedName("type-id")
    private String typeId;

    @SerializedName("relations")
    private List<MusicBrainzRelation> relations = null;

    @SerializedName("gender")
    private String gender;

    @SerializedName("name")
    private String name;

    public List<MusicBrainzReleaseGroup> getReleaseGroups() {
        return releaseGroups;
    }

    public void setReleaseGroups(List<MusicBrainzReleaseGroup> releaseGroups) {
        this.releaseGroups = releaseGroups;
    }

    public List<String> getIsnis() {
        return isnis;
    }

    public void setIsnis(List<String> isnis) {
        this.isnis = isnis;
    }

    public MusicBrainzArea getArea() {
        return area;
    }

    public void setArea(MusicBrainzArea area) {
        this.area = area;
    }

    public MusicBrainzLifeSpan getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(MusicBrainzLifeSpan lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public List<String> getIpis() {
        return ipis;
    }

    public void setIpis(List<String> ipis) {
        this.ipis = ipis;
    }

    public MusicBrainzBeginArea getBeginArea() {
        return beginArea;
    }

    public void setBeginArea(MusicBrainzBeginArea beginArea) {
        this.beginArea = beginArea;
    }

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

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getEndArea() {
        return endArea;
    }

    public void setEndArea(Object endArea) {
        this.endArea = endArea;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<MusicBrainzRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<MusicBrainzRelation> relations) {
        this.relations = relations;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
