
package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Relation entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzRelation {

    @SerializedName("url")
    private MusicBrainzUrl url;

    @SerializedName("type-id")
    private String typeId;

    @SerializedName("attributes")
    private List<Object> attributes = null;

    @SerializedName("target-credit")
    private String targetCredit;

    @SerializedName("begin")
    private Object begin;

    @SerializedName("type")
    private String type;

    @SerializedName("end")
    private Object end;

    @SerializedName("ended")
    private Boolean ended;

    @SerializedName("direction")
    private String direction;

    @SerializedName("source-credit")
    private String sourceCredit;

    @SerializedName("target-type")
    private String targetType;

    public MusicBrainzUrl getUrl() {
        return url;
    }

    public void setUrl(MusicBrainzUrl url) {
        this.url = url;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public String getTargetCredit() {
        return targetCredit;
    }

    public void setTargetCredit(String targetCredit) {
        this.targetCredit = targetCredit;
    }

    public Object getBegin() {
        return begin;
    }

    public void setBegin(Object begin) {
        this.begin = begin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSourceCredit() {
        return sourceCredit;
    }

    public void setSourceCredit(String sourceCredit) {
        this.sourceCredit = sourceCredit;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

}
