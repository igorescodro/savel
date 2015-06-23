package com.escodro.savel.network.spotify.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.escodro.savel.network.spotify.SpotifyAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Object to represent an implements Parcelable {@link SpotifyAPI} {@link Item}. An {@link Item} can
 * be an Artist, an Album, a Track or a Playlist.
 */
public class Item implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    /**
     * {@link Item} id.
     */
    private String id;
    /**
     * {@link Item} followers.
     */
    private Follower followers;
    /**
     * {@link Item} external urls.
     */
    private ExternalUrl external_urls;
    /**
     * {@link Item} genres.
     */
    private List<String> genres;
    /**
     * {@link Item} name.
     */
    private String name;
    /**
     * {@link Item} images.
     */
    private List<Image> images;
    /**
     * {@link Item} type.
     */
    private String type;
    /**
     * {@link Item} uri.
     */
    private String uri;
    /**
     * {@link Item} href.
     */
    private String href;
    /**
     * {@link Item} popularity.
     */
    private String popularity;

    protected Item(Parcel in) {
        id = in.readString();
        followers = (Follower) in.readValue(Follower.class.getClassLoader());
        external_urls = (ExternalUrl) in.readValue(ExternalUrl.class.getClassLoader());
        if (in.readByte() == 0x01) {
            genres = new ArrayList<>();
            in.readList(genres, String.class.getClassLoader());
        } else {
            genres = null;
        }
        name = in.readString();
        if (in.readByte() == 0x01) {
            images = new ArrayList<>();
            in.readList(images, Image.class.getClassLoader());
        } else {
            images = null;
        }
        type = in.readString();
        uri = in.readString();
        href = in.readString();
        popularity = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Follower getFollowers() {
        return followers;
    }

    public void setFollowers(Follower followers) {
        this.followers = followers;
    }

    public ExternalUrl getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalUrl external_urls) {
        this.external_urls = external_urls;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeValue(followers);
        dest.writeValue(external_urls);
        if (genres == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genres);
        }
        dest.writeString(name);
        if (images == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(images);
        }
        dest.writeString(type);
        dest.writeString(uri);
        dest.writeString(href);
        dest.writeString(popularity);
    }
}
