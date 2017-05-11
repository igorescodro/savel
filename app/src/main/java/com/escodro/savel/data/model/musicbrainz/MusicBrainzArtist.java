package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getArea() {
        String areaName = null;
        if (area != null) {
            areaName = area.getName();
        }
        return areaName;
    }

    @NonNull
    public List<MusicBrainzReleaseGroup> getReleases() {
        if (releaseGroups == null) {
            releaseGroups = new ArrayList<>();
        }
        return releaseGroups;
    }

    @NonNull
    public List<MusicBrainzRelation> getRelations() {
        if (relations == null) {
            relations = new ArrayList<>();
        }
        return relations;
    }
}
