package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Area entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
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

    @Nullable
    public String getName() {
        return name;
    }
}
