package com.escodro.savel.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Object to represent an universal compilation of all APIs, collecting all useful information about
 * an implements Parcelable {@link Artist}.
 * <p/>
 * Created by IgorEscodro on 03/07/15.
 */
public class Artist implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
    /**
     * {@link MusicBrainzAPI} id.
     */
    private String id;
    /**
     * {@link Artist} name.
     */
    private String name;
    /**
     * {@link Artist} tags.
     */
    private List<String> tags;
    /**
     * {@link Artist} biography.
     */
    private String bio;
    /**
     * {@link Artist} image url.
     */
    private String imageUrl;
    /**
     * {@link Artist} popularity.
     */
    private int popularity;
    /**
     * {@link Artist} country.
     */
    private String country;
    /**
     * {@link Artist} city.
     */
    private String city;
    /**
     * {@link Artist} releases.
     */
    private List<Release> releases;
    /**
     * {@link Artist} similar.
     */
    private List<Artist> similar;
    /**
     * {@link Artist} relations.
     */
    private List<Relation> relations;

    /**
     * Default constructor.
     */
    public Artist() {
        //Do nothing.
    }

    protected Artist(Parcel in) {
        id = in.readString();
        name = in.readString();
        if (in.readByte() == 0x01) {
            tags = new ArrayList<>();
            in.readList(tags, String.class.getClassLoader());
        } else {
            tags = null;
        }
        bio = in.readString();
        imageUrl = in.readString();
        popularity = in.readInt();
        country = in.readString();
        city = in.readString();
        if (in.readByte() == 0x01) {
            releases = new ArrayList<>();
            in.readList(releases, Release.class.getClassLoader());
        } else {
            releases = null;
        }
        if (in.readByte() == 0x01) {
            similar = new ArrayList<>();
            in.readList(similar, Artist.class.getClassLoader());
        } else {
            similar = null;
        }
        if (in.readByte() == 0x01) {
            relations = new ArrayList<>();
            in.readList(relations, Relation.class.getClassLoader());
        } else {
            relations = null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public List<Artist> getSimilar() {
        return similar;
    }

    public void setSimilar(List<Artist> similar) {
        this.similar = similar;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        if (tags == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(tags);
        }
        dest.writeString(bio);
        dest.writeString(imageUrl);
        dest.writeInt(popularity);
        dest.writeString(country);
        dest.writeString(city);
        if (releases == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(releases);
        }
        if (similar == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(similar);
        }
        if (relations == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(relations);
        }
    }
}
