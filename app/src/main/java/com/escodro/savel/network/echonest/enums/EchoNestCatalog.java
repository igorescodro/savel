package com.escodro.savel.network.echonest.enums;

import com.escodro.savel.network.echonest.model.Artist;
import com.escodro.savel.network.echonest.model.EchoNestResponse;
import com.escodro.savel.network.echonest.model.ForeignId;

/**
 * Enum to represent the possible {@link ForeignId} from an {@link EchoNestResponse}. Each one is an
 * website or database with {@link Artist} information.
 * <p/>
 * Created by IgorEscodro on 06/07/15.
 */
public enum EchoNestCatalog {

    /**
     * Reference to MusicBrainz
     */
    MUSICBRAINZ("musicbrainz");

    /**
     * Field to represent the catalog string.
     */
    private final String mCatalog;

    /**
     * Create a new instance of {@link EchoNestCatalog}.
     *
     * @param catalog {@link ForeignId} id
     */
    EchoNestCatalog(String catalog) {
        mCatalog = catalog;
    }

    /**
     * Convert {@link EchoNestCatalog} to {@link String}.
     *
     * @return {@link EchoNestCatalog} name
     */
    @Override
    public String toString() {
        return mCatalog;
    }
}
