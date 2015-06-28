package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

/**
 * Object to represent an {@link LastFmAPI} {@link Formation}.
 */
public class FormationList {

    /**
     * {@link Formation} formation.
     */
    private Formation formation;

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
