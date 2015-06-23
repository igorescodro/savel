package com.escodro.savel.network.spotify.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.escodro.savel.network.spotify.SpotifyAPI;

/**
 * Object to represent an implements Parcelable {@link SpotifyAPI} {@link Image}.
 */
public class Image implements Parcelable {
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
    /**
     * {@link Image} height.
     */
    private String height;
    /**
     * {@link Image} width.
     */
    private String width;
    /**
     * {@link Image} url.
     */
    private String url;

    protected Image(Parcel in) {
        height = in.readString();
        width = in.readString();
        url = in.readString();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
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
        dest.writeString(height);
        dest.writeString(width);
        dest.writeString(url);
    }
}
