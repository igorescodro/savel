package com.escodro.savel.data.local.provider;

import com.escodro.savel.data.model.SavelArtist;

/**
 * Class to provide {@link SavelArtist} information. Currently, the store mechanism is only setting
 * the data in a field in memory. A future implementation will add database and cache mechanism.
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */
public class ArtistProvider extends ObservableProvider<SavelArtist> {

    private SavelArtist mArtist;

    @Override
    protected void onStoreData(SavelArtist data) {
        mArtist = data;
    }

    @Override
    public SavelArtist retrieveData() {
        return mArtist;
    }
}
