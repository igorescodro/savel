package com.escodro.savel.network.spotify.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.escodro.savel.network.spotify.SpotifyAPI;

/**
 * Object to represent an implements Parcelable {@link SpotifyAPI} {@link Follower}.
 */
public class Follower implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Follower> CREATOR = new Parcelable.Creator<Follower>() {
        @Override
        public Follower createFromParcel(Parcel in) {
            return new Follower(in);
        }

        @Override
        public Follower[] newArray(int size) {
            return new Follower[size];
        }
    };
    /**
     * {@link Follower} total.
     */
    private String total;
    /**
     * {@link Follower} href.
     */
    private String href;

    protected Follower(Parcel in) {
        total = in.readString();
        href = in.readString();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(total);
        dest.writeString(href);
    }
}
