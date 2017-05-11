package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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

    @NonNull
    public List<MusicBrainzArtist> getArtists() {
        if (artists == null) {
            artists = new ArrayList<>();
        }
        return artists;
    }
}
