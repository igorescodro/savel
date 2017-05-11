package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Url entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzUrl {

    @SerializedName("id")
    private String id;

    @SerializedName("resource")
    private String resource;

    @Nullable
    public String getUrl() {
        return resource;
    }
}
