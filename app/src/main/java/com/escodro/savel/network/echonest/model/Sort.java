package com.escodro.savel.network.echonest.model;

import com.escodro.savel.network.echonest.EchoNestAPI;

/**
 * {@link Enum} to represent the {@link Sort} option to {@link EchoNestAPI} data.
 *
 * @see <a href="http://developer.echonest.com/docs/v4">Echo Nest API Overview</a>
 * <p/>
 * Created by IgorEscodro on 04/06/15.
 */
public enum Sort {

    /**
     * Sort ASC by the estimation of how familiar an artist currently is to the world.
     */
    FAMILIARITY_ASC("familiarity-asc"),

    /**
     * Sort DESC by the estimation of how familiar an artist currently is to the world.
     */
    FAMILIARITY_DESC("familiarity-desc"),

    /**
     * Sort ASC by the numerical description of how hot an artist currently is.
     */
    HOTNESS_ASC("hotttnesss-asc"),

    /**
     * Sort DESC by the numerical description of how hot an artist currently is.
     */
    HOTNESS_DESC("hotttnesss-desc"),

    /**
     * Sort ASC by the start year of the artist.
     */
    ARTIST_START_YEAR_ASC("artist_start_year-asc"),

    /**
     * Sort DESC by the start year of the artist.
     */
    ARTIST_START_YEAR_DESC("artist_start_year-desc"),

    /**
     * Sort ASC by the end year of the artist.
     */
    ARTIST_END_YEAR_ASC("artist_end_year-asc"),

    /**
     * Sort DESC by the end year of the artist.
     */
    ARTIST_END_YEAR_DESC("artist_end_year-desc");

    /**
     * Reference of Sort name.
     */
    private final String mSort;

    /**
     * Construct a new {@link Sort}.
     *
     * @param sort {@link Sort} name.
     */
    Sort(String sort) {
        mSort = sort;
    }

    /**
     * Convert {@link Sort} to {@link String}.
     *
     * @return {@link Sort} name
     */
    @Override
    public String toString() {
        return mSort;
    }
}
