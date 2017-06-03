package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("first-release-date")
    private String firstReleaseDate;

    @SerializedName("id")
    private String id;

    @Nullable
    public String getPrimaryType() {
        return primaryType;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public String getReleaseDate() {
        return firstReleaseDate;
    }
}
