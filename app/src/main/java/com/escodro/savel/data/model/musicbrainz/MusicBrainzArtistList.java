package com.escodro.savel.data.model.musicbrainz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the ArtistList entity returned in a search query in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzArtistList {

    @SerializedName("created")
    private String created;

    @SerializedName("count")
    private Integer count;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("artists")
    private List<MusicBrainzArtist> artists = null;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<MusicBrainzArtist> getArtists() {
        return artists;
    }

    public void setArtists(List<MusicBrainzArtist> artists) {
        this.artists = artists;
    }

}
