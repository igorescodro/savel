package com.escodro.savel.data.local.provider;

import com.escodro.savel.data.model.Artist;

/**
 * Class to provide {@link Artist} information. Currently, the store mechanism is only setting
 * the data in a field in memory. A future implementation will add database and cache mechanism.
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */
public class ArtistProvider extends ObservableProvider<Artist> {

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
