package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Area entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzArea {

    @SerializedName("name")
    private String name;

    @SerializedName("sort-name")
    private String sortName;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("id")
    private String id;

    @Nullable
    public String getName() {
        return name;
    }
}
