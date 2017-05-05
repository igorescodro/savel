package com.escodro.savel.data.local.provider;

import com.escodro.savel.data.model.Artist;

/**
 * Created by Igor Escodro on 05/05/17.
 */

public class ArtistProvider extends Provider<Artist> {

    private Artist mArtist;

    @Override
    protected void onStoreData(Artist data) {
        mArtist = data;
    }

    @Override
    public Artist retrieveData() {
        return mArtist;
    }
}
