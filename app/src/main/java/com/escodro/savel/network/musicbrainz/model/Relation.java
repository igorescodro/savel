package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link Relation}.
 */
public class Relation {

    /**
     * {link Relation} target credit.
     */
    @SerializedName("target-credit")
    private String target_credit;

    /**
     * {link Relation} direction.
     */
    private String direction;

    /**
     * {link Relation} type id.
     */
    @SerializedName("type-id")
    private String type_id;

    /**
     * {link Relation} source credit.
     */
    @SerializedName("source-credit")
    private String source_credit;

    /**
     * {link Relation} attributes.
     */
    private String[] attributes;

    /**
     * {link Relation} ended.
     */
    private String ended;

    /**
     * {link Relation} type.
     */
    private String type;

    /**
     * {link Relation} url.
     */
    private Url url;

    /**
     * {link Relation} end.
     */
    private String end;

    /**
     * {link Relation} begin.
     */
    private String begin;

    public String getTargetCredit() {
        return target_credit;
    }

    public void setTargetCredit(String target_credit) {
        this.target_credit = target_credit;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTypeId() {
        return type_id;
    }

    public void setTypeId(String type_id) {
        this.type_id = type_id;
    }

    public String getSourceCredit() {
        return source_credit;
    }

    public void setSourceCredit(String source_credit) {
        this.source_credit = source_credit;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
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
