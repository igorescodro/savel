package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

/**
 * Object to represent an {@link LastFmAPI} {@link Formation}.
 */
public class Formation {

    /**
     * {@link Formation} year to.
     */
    private String yearto;

    /**
     * {@link Formation} year from.
     */
    private String yearfrom;

    public String getYearto() {
        return yearto;
    }

    public void setYearto(String yearto) {
        this.yearto = yearto;
    }

    public String getYearfrom() {
        return yearfrom;
    }

    public void setYearfrom(String yearfrom) {
        this.yearfrom = yearfrom;
    }
}
