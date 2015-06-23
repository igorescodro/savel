package com.escodro.savel.network.spotify.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.escodro.savel.network.spotify.SpotifyAPI;

/**
 * Object to represent an implements Parcelable {@link SpotifyAPI} {@link ExternalUrl}.
 */
public class ExternalUrl implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ExternalUrl> CREATOR = new Parcelable
            .Creator<ExternalUrl>() {
        @Override
        public ExternalUrl createFromParcel(Parcel in) {
            return new ExternalUrl(in);
        }

        @Override
        public ExternalUrl[] newArray(int size) {
            return new ExternalUrl[size];
        }
    };
    /**
     * {@link ExternalUrl} spotify.
     */
    private String spotify;

    protected ExternalUrl(Parcel in) {
        spotify = in.readString();
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(spotify);
    }
}
