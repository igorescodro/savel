package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzReleaseGroup;
import com.escodro.savel.data.model.spotify.SpotifyArtist;

import java.util.ArrayList;
import java.util.List;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class SavelArtist {

    private final MusicBrainzArtist mMusicBrainzArtist;

    private final DiscogsArtist mDiscogsArtist;

    private List<SavelTweet> mTweetList;

    private final SpotifyArtist mSpotifyArtist;

    private List<SavelInstagram> mInstaTimeline;

    private List<SavelFacebook> mFacebookTimeline;

    private List<SavelRelease> mReleases;

    public SavelArtist(MusicBrainzArtist musicBrainzArtist,
                       DiscogsArtist discogsArtist,
                       List<SavelTweet> tweetList,
                       SpotifyArtist spotifyArtist,
                       List<SavelInstagram> instaTimeline,
                       List<SavelFacebook> facebookTimeline) {
        mMusicBrainzArtist = musicBrainzArtist;
        mDiscogsArtist = discogsArtist;
        mTweetList = tweetList;
        mSpotifyArtist = spotifyArtist;
        mInstaTimeline = instaTimeline;
        mFacebookTimeline = facebookTimeline;
        mReleases = convertToReleases();
    }

    public SavelArtist(MusicBrainzArtist musicBrainzArtist) {
        this(musicBrainzArtist, null, null, null, null, null);
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
    public List<SavelTweet> getTweetList() {
        if (mTweetList == null) {
            mTweetList = new ArrayList<>();
        }
        return mTweetList;
    }

    @NonNull
    public List<SavelInstagram> getInstagramTimeline() {
        if (mInstaTimeline == null) {
            mInstaTimeline = new ArrayList<>();
        }
        return mInstaTimeline;
    }

    @NonNull
    public List<SavelFacebook> getFacebookTimeline() {
        if (mFacebookTimeline == null) {
            mFacebookTimeline = new ArrayList<>();
        }
        return mFacebookTimeline;
    }

    @NonNull
    public List<SavelRelease> getReleases() {
        if (mReleases == null) {
            mReleases = new ArrayList<>();
        }
        return mReleases;
    }

    @NonNull
    private List<SavelRelease> convertToReleases() {
        final List<SavelRelease> releases = new ArrayList<>();
        final List<MusicBrainzReleaseGroup> mbReleases = mMusicBrainzArtist.getReleases();
        for (MusicBrainzReleaseGroup releaseGroup : mbReleases) {
            final SavelRelease release = new SavelRelease();
            release.setReleaseGroup(releaseGroup);
            releases.add(release);
        }
        return releases;
    }
}
