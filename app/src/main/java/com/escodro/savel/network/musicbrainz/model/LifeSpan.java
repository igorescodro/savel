package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link LifeSpan}.
 */
public class LifeSpan {

    /**
     * {link LifeSpan} ended.
     */
    private String ended;

    /**
     * {link LifeSpan} end.
     */
    private String end;

    /**
     * {link LifeSpan} begin.
     */
    private String begin;

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }
}
