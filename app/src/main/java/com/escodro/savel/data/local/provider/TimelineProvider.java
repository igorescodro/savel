package com.escodro.savel.data.local.provider;

import com.escodro.savel.data.model.SavelTimeline;

/**
 * Class to provide {@link SavelTimeline} information.
 * <p/>
 * Created by Igor Escodro on 07/06/17.
 */
public class TimelineProvider extends ObservableProvider<SavelTimeline> {

    private SavelTimeline mTimeline;

    @Override
    protected void onStoreData(SavelTimeline data) {
        mTimeline = data;
    }

    @Override
    public SavelTimeline retrieveData() {
        return mTimeline;
    }
}
