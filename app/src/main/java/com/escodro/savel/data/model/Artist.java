package com.escodro.savel.data.model;

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

    public String getName() {
        return mMusicBrainzArtist.getName();
    }

    public String getBio() {
        return mDiscogsArtist.getProfile();
    }

    public String getImage() {
        return mDiscogsArtist.getImages().get(0).getResourceUrl();
    }
}
