package com.escodro.savel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Object to represent a implements Parcelable {@link Release} from an {@link Artist}. A release can
 * be an Album, a Compilation, a Single, a EP or any other source of songs officially released.
 * <p/>
 * Created by IgorEscodro on 22/08/15.
 */
public class Release implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Release> CREATOR = new Parcelable.Creator<Release>() {
        @Override
        public Release createFromParcel(Parcel in) {
            return new Release(in);
        }

        @Override
        public Release[] newArray(int size) {
            return new Release[size];
        }
    };
    /**
     * {@link Release} id.
     */
    private String id;
    /**
     * {@link Release} title.
     */
    private String title;
    /**
     * {@link Release} date.
     */
    private Date releaseDate;
    /**
     * {@link Release} primary type.
     */
    private String primaryType;
    /**
     * {@link Release} secondary type.
     */
    private String secondaryType;

    /**
     * Default constructor.
     */
    public Release() {
        //Do nothing.
    }

    protected Release(Parcel in) {
        id = in.readString();
        title = in.readString();
        long tmpReleaseDate = in.readLong();
        releaseDate = tmpReleaseDate != -1 ? new Date(tmpReleaseDate) : null;
        primaryType = in.readString();
        secondaryType = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : -1L);
        dest.writeString(primaryType);
        dest.writeString(secondaryType);
    }
}
