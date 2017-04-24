package com.escodro.savel.data.model;

import android.support.annotation.Nullable;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class Artist {

    private MusicBrainzArtist mMusicBrainzArtist;

    private DiscogsArtist mDiscogsArtist;

    public Artist(MusicBrainzArtist musicBrainzArtist, DiscogsArtist discogsArtist) {
        mMusicBrainzArtist = musicBrainzArtist;
        mDiscogsArtist = discogsArtist;
    }

    public Artist(MusicBrainzArtist musicBrainzArtist) {
        mMusicBrainzArtist = musicBrainzArtist;
    }

    @Nullable
    public String getId() {
        String id = null;
        if (mMusicBrainzArtist != null) {
            id = mMusicBrainzArtist.getId();
        }
        return id;
    }

    @Nullable
    public String getName() {
        String name = null;
        if (mMusicBrainzArtist != null) {
            name = mMusicBrainzArtist.getName();
        }
        return name;
    }

    @Nullable
    public String getBio() {
        String bio = null;
        if (mDiscogsArtist != null) {
            bio = mDiscogsArtist.getProfile();
        }
        return bio;
    }

    @Nullable
    public String getImage() {
        String image = null;
        if (mDiscogsArtist != null && mDiscogsArtist.getImages() != null) {
            image = mDiscogsArtist.getImages().get(0).getResourceUrl();
        }
        return image;
    }
}
