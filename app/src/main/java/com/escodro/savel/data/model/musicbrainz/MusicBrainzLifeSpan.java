package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the LifeSpan entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzLifeSpan {

    @SerializedName("ended")
    private Boolean ended;

    @SerializedName("end")
    private Object end;

    @SerializedName("begin")
    private String begin;
}
