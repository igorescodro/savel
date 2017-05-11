package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the BeginArea entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzBeginArea {

    @SerializedName("name")
    private String name;

    @SerializedName("disambiguation")
    private String disambiguation;

    @SerializedName("sort-name")
    private String sortName;

    @SerializedName("id")
    private String id;
}
