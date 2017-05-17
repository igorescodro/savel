package com.escodro.savel.data.model.musicbrainz;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

/**
 * Object to represent the ReleaseGroup List entity in
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
 */
public class MusicBrainzReleaseGroupList {

    @SerializedName("release-groups")
    private List<MusicBrainzReleaseGroup> releaseGroups = null;

    @NonNull
    public List<MusicBrainzReleaseGroup> getReleaseGroups() {
        List<MusicBrainzReleaseGroup> releases = releaseGroups;
        if (releaseGroups == null) {
            releaseGroups = Collections.emptyList();
        }
        return releases;
    }
}
