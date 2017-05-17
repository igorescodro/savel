package com.escodro.savel.data.local.contract;

import com.escodro.savel.BuildConfig;
import com.escodro.savel.ui.artist.releases.ReleaseItemViewModel;

import javax.inject.Inject;

/**
 * Class containing the contract methods related to {@link ReleaseItemViewModel}.
 * <p>
 * Created by Igor Escodro on 12/05/17.
 */
public class ReleaseItemContract {

    @Inject
    public ReleaseItemContract() {
    }

    /**
     * Get the respective cover art URL based on the release group id from
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
     *
     * @param rgid MusicBrainz release group id
     *
     * @return cover art URL
     */
    public String getCoverArtUrl(String rgid) {
        return String.format(BuildConfig.API_COVER_ART_ENDPOINT, rgid);
    }

}
