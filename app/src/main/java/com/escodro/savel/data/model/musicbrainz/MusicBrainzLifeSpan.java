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

    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

}
