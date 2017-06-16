package com.escodro.savel.data.local.provider;

import com.escodro.savel.data.local.database.model.ArtistRealm;
import com.escodro.savel.data.model.SavelArtist;

/**
 * Class to provide {@link SavelArtist} information.
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */
public class ArtistProvider extends ObservableProvider<ArtistRealm> {

    private ArtistRealm mArtist;

    @Override
    protected void onStoreData(ArtistRealm data) {
        mArtist = data;
    }

    @Override
    public ArtistRealm retrieveData() {
        return mArtist;
    }
}
