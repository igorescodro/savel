package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.echonest.EchoNestAPI;

/**
 * {@link Enum} to represent the {@link Type} option to {@link EchoNestAPI} data.
 *
 * @see <a href="http://developer.echonest.com/docs/v4">Echo Nest API Overview</a>
 * <p/>
 * Created by IgorEscodro on 04/06/15.
 */
public enum Type {

    /**
     * Represent that the {@link Item} type is an Album.
     */
    ALBUM("album"),

    /**
     * Represent that the {@link Item} type is an Artist.
     */
    ARTIST("artist"),

    /**
     * Represent that the {@link Item} type is a Track.
     */
    TRACK("track"),

    /**
     * Represent that the {@link Item} type is a Playlist.
     */
    PLAYLIST("playlist");

    /**
     * Reference of Sort name.
     */
    private final String mType;

    /**
     * Construct a new {@link Type}.
     *
     * @param sort {@link Type} name.
     */
    Type(String sort) {
        mType = sort;
    }

    /**
     * Convert {@link Type} to {@link String}.
     *
     * @return {@link Type} name
     */
    @Override
    public String toString() {
        return mType;
    }
}
