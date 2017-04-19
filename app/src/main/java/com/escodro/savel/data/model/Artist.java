package com.escodro.savel.data.model;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class Artist {

    private MusicBrainzArtist mMusicBrainzArtist;

    public Artist(MusicBrainzArtist musicBrainzArtist) {
        mMusicBrainzArtist = musicBrainzArtist;
    }

    public String getName() {
        return mMusicBrainzArtist.getName();
    }

    public String getBio() {
        return mMusicBrainzArtist.getCountry();
    }

}
