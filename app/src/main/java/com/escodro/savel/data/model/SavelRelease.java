package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroup;

import javax.inject.Inject;

/**
 * Object containing the consolidated information about the artist releases.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class SavelRelease {

    private MusicBrainzReleaseGroup mReleaseGroup;

    @Inject
    public SavelRelease() {
    }

    public void setReleaseGroup(@NonNull MusicBrainzReleaseGroup releaseGroup) {
        mReleaseGroup = releaseGroup;
    }

    @Nullable
    public String getId() {
        String id = null;
        if (mReleaseGroup != null) {
            id = mReleaseGroup.getId();
        }
        return id;
    }

    @Nullable
    public String getPrimaryType() {
        String primaryType = null;
        if (mReleaseGroup != null) {
            primaryType = mReleaseGroup.getPrimaryType();
        }
        return primaryType;
    }

    @Nullable
    public String getTitle() {
        String title = null;
        if (mReleaseGroup != null) {
            title = mReleaseGroup.getTitle();
        }
        return title;
    }

    @Nullable
    public String getReleaseDate() {
        String releaseDate = null;
        if (mReleaseGroup != null) {
            releaseDate = mReleaseGroup.getReleaseDate();
        }
        return releaseDate;
    }
}
