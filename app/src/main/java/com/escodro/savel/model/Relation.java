package com.escodro.savel.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Object to represent a external implements Parcelable {@link Relation} from the {@link Artist}. A
 * relation is an url from an social media (Facebook, Twitter, SoundCloud etc) or an information
 * site (Wikipedia, Discogs, BBC Music etc).
 * <p/>
 * Created by IgorEscodro on 22/08/15.
 */

public class Relation implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Relation> CREATOR = new Parcelable.Creator<Relation>() {
        @Override
        public Relation createFromParcel(Parcel in) {
            return new Relation(in);
        }

        @Override
        public Relation[] newArray(int size) {
            return new Relation[size];
        }
    };
    /**
     * {@link Relation} type.
     */
    private String type;
    /**
     * {@link Relation} url.
     */
    private String url;

    /**
     * Default constructor.
     */
    public Relation() {
        //Do nothing.
    }

    protected Relation(Parcel in) {
        type = in.readString();
        url = in.readString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(url);
    }
}
