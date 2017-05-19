package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroup;
import com.escodro.savel.util.adapter.DateConverter;

/**
 * Object containing the consolidated information about the artist releases.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class SavelRelease {

    /**
     * Constant to represent the possible date formats coming from the server.
     */
    private static final String[] DATE_FORMATS = {"yyyy-MM-dd", "yyyy", "yyyy-MM"};

    private final MusicBrainzReleaseGroup mReleaseGroup;

    public SavelRelease(@NonNull MusicBrainzReleaseGroup releaseGroup) {
        mReleaseGroup = releaseGroup;
    }

    @Nullable
    public String getId() {
        return mReleaseGroup.getId();
    }

    @Nullable
    public String getPrimaryType() {
        return mReleaseGroup.getPrimaryType();
    }

    @Nullable
    public String getTitle() {
        return mReleaseGroup.getTitle();
    }

    public long getReleaseDateInMillis() {
        long releaseDate = 0;
        if (mReleaseGroup.getReleaseDate() != null) {
            releaseDate = DateConverter.timeToMillis(mReleaseGroup.getReleaseDate(), DATE_FORMATS);
        }
        return releaseDate;
    }
}
