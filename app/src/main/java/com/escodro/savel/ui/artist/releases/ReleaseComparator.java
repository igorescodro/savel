package com.escodro.savel.ui.artist.releases;

import com.escodro.savel.data.model.SavelRelease;

import java.util.Comparator;

import javax.inject.Inject;

/**
 * Custom comparator to sort descending the {@link SavelRelease} based on the time of the
 * release.
 * <p/>
 * Created by Igor Escodro on 17/05/17.
 */
public class ReleaseComparator implements Comparator<SavelRelease> {

    /**
     * Default injectable constructor.
     */
    @Inject
    public ReleaseComparator() {
    }

    @Override
    public int compare(SavelRelease r0, SavelRelease r1) {
        return Long.compare(r1.getReleaseDateInMillis(), r0.getReleaseDateInMillis());
    }
}
