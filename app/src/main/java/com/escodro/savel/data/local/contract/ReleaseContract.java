package com.escodro.savel.data.local.contract;

import android.support.annotation.NonNull;
import android.support.annotation.StringDef;

import com.escodro.savel.data.model.SavelRelease;
import com.escodro.savel.ui.artist.releases.ReleaseComparator;
import com.escodro.savel.ui.artist.releases.ReleaseViewModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Class containing the contract methods related to {@link ReleaseViewModel}.
 * <p>
 * Created by Igor Escodro on 17/05/17.
 */
public class ReleaseContract {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ALBUM, SINGLE})
    public @interface ReleaseType {
    }

    private static final String ALBUM = "Album";

    private static final String SINGLE = "Single";

    private final Map<String, List<SavelRelease>> mSubReleases;

    @Inject
    ReleaseComparator mReleaseComparator;

    @Inject
    public ReleaseContract() {
        mSubReleases = new HashMap<>();
    }

    /**
     * Set the {@link List} of {@link SavelRelease} to be filtered in sublists based on
     * {@link ReleaseType}.
     *
     * @param releases list of all releases
     */
    public void setReleaseList(@NonNull List<SavelRelease> releases) {
        releases.sort(mReleaseComparator);
        processList(releases);
    }

    /**
     * Method to create sublists of {@link SavelRelease} based on the {@link ReleaseType}.
     *
     * @param releases list of all releases
     *
     * @see <a href="http://stackoverflow.com/a/3836694">split a java collection into sub
     * collections based on a object property | Stack Overflow</a>
     */
    private void processList(@NonNull List<SavelRelease> releases) {
        for (SavelRelease release : releases) {
            final String primaryType = release.getPrimaryType();
            List<SavelRelease> temp = mSubReleases.get(primaryType);
            if (temp == null) {
                temp = new ArrayList<>();
                mSubReleases.put(primaryType, temp);
            }
            temp.add(release);
        }
    }

    /**
     * Get the sublist containing only the {@link SavelRelease} with
     * type {@link ReleaseContract#ALBUM}.
     *
     * @return list of album releases
     */
    @NonNull
    public List<SavelRelease> getAlbumReleases() {
        return getReleasesByType(ALBUM);
    }

    /**
     * Get the sublist containing only the {@link SavelRelease} with
     * type {@link ReleaseContract#SINGLE}.
     *
     * @return list of single releases
     */
    @NonNull
    public List<SavelRelease> getSingleReleases() {
        return getReleasesByType(SINGLE);
    }

    @NonNull
    private List<SavelRelease> getReleasesByType(@NonNull @ReleaseType String type) {
        List<SavelRelease> releases = mSubReleases.get(type);
        if (releases == null) {
            releases = Collections.emptyList();
        }
        return releases;
    }
}
