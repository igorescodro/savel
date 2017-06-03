
package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Relation entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzRelation {

    @SerializedName("url")
    private MusicBrainzUrl url;

    @SerializedName("type-id")
    private String typeId;

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

    @Nullable
    public String getUrl() {
        String urlStr = null;
        if (url != null) {
            urlStr = url.getUrl();
        }
        return urlStr;
    }

    @Nullable
    public String getType() {
        return type;
    }
}
