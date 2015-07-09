package com.escodro.savel.network.musicbrainz.model;

import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;

/**
 * Object to represent an {@link MusicBrainzAPI} {@link Url}.
 */
public class Url {

    /**
     * {link Url} id.
     */
    private String id;

    /**
     * {link Url} relations.
     */
    private String[] relations;

    /**
     * {link Url} resource.
     */
    private String resource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getRelations() {
        return relations;
    }

    public void setRelations(String[] relations) {
        this.relations = relations;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
