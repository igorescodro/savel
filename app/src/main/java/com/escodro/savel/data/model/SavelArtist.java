package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzRelation;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroup;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroupList;
import com.escodro.savel.data.model.spotify.SpotifyArtist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class SavelArtist {

    private final MusicBrainzArtist mMusicBrainzArtist;

    private final DiscogsArtist mDiscogsArtist;

    private final SpotifyArtist mSpotifyArtist;

    private List<SavelRelease> mReleases;

    public SavelArtist(MusicBrainzArtist musicBrainzArtist,
            DiscogsArtist discogsArtist,
            SpotifyArtist spotifyArtist,
            MusicBrainzReleaseGroupList releaseGroupList) {
        mMusicBrainzArtist = musicBrainzArtist;
        mDiscogsArtist = discogsArtist;
        mSpotifyArtist = spotifyArtist;
        mReleases = convertToReleases(releaseGroupList);
    }

    public SavelArtist(MusicBrainzArtist musicBrainzArtist) {
        this(musicBrainzArtist, null, null, null);
    }

    @Nullable
    public String getId() {
        String id = null;
        if (mMusicBrainzArtist != null) {
            id = mMusicBrainzArtist.getId();
        }
        return id;
    }

    @Nullable
    public String getName() {
        String name = null;
        if (mMusicBrainzArtist != null) {
            name = mMusicBrainzArtist.getName();
        }
        return name;
    }

    @Nullable
    public String getBio() {
        String bio = null;
        if (mDiscogsArtist != null) {
            bio = mDiscogsArtist.getProfile();
        }
        return bio;
    }

    /**
     * Get artist image, trying first from
     * {@link com.escodro.savel.data.remote.service.SpotifyService} because of its better
     * quality, If no image was found, try the image from
     * {@link com.escodro.savel.data.remote.service.DiscogsService}.
     *
     * @return artist image
     */
    @Nullable
    public String getImage() {
        String image = null;

        if (mSpotifyArtist != null && mSpotifyArtist.getImages() != null) {
            image = mSpotifyArtist.getImages().get(0).getUrl();
        } else if (mDiscogsArtist != null && mDiscogsArtist.getImages() != null) {
            image = mDiscogsArtist.getImages().get(0).getResourceUrl();
        }
        return image;
    }

    @Nullable
    public String getArea() {
        String area = null;

        if (mMusicBrainzArtist != null && mMusicBrainzArtist.getArea() != null) {
            area = mMusicBrainzArtist.getArea();
        }
        return area;
    }

    @NonNull
    public List<SavelRelease> getReleases() {
        if (mReleases == null) {
            mReleases = Collections.emptyList();
        }
        return mReleases;
    }

    @NonNull
    public List<MusicBrainzRelation> getRelations() {
        List<MusicBrainzRelation> relations = Collections.emptyList();
        if (mMusicBrainzArtist != null) {
            relations = mMusicBrainzArtist.getRelations();
        }
        return relations;
    }

    @NonNull
    private List<SavelRelease> convertToReleases(MusicBrainzReleaseGroupList releaseGroupList) {
        if (releaseGroupList == null) {
            return Collections.emptyList();
        }

        final List<SavelRelease> releases = new ArrayList<>();
        final List<MusicBrainzReleaseGroup> mbReleases = releaseGroupList.getReleaseGroups();
        for (MusicBrainzReleaseGroup releaseGroup : mbReleases) {
            final SavelRelease release = new SavelRelease(releaseGroup);
            releases.add(release);
        }
        return releases;
    }
}
