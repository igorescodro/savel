package com.escodro.savel.network.echonest.model;

import com.escodro.savel.network.echonest.EchoNestAPI;
import com.escodro.savel.network.echonest.enums.EchoNestCatalog;

import java.util.List;

/**
 * Object to represent an {@link EchoNestAPI} {@link Artist}.
 */
public class Artist {

    /**
     * {@link Artist} id.
     */
    private String id;

    /**
     * {@link Artist} foreign ids.
     */
    private List<ForeignId> foreign_ids;

    /**
     * {@link Artist} name.
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ForeignId> getForeign_ids() {
        return foreign_ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the {@link Artist}'s MusicBrainz id.
     *
     * @return MusicBrainz id.
     */
    public String getMusicBrainzId() {
        String mbid = null;
        for (ForeignId id : foreign_ids) {
            if (id.getCatalog().equals(EchoNestCatalog.MUSICBRAINZ.toString())) {
                mbid = id.getForeign_id();
                mbid = mbid.substring(mbid.lastIndexOf(":") + 1, mbid.length());
                break;
            }
        }
        return mbid;
    }
}
