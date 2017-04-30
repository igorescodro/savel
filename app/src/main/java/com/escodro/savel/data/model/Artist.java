package com.escodro.savel.data.model;

import android.support.annotation.Nullable;

import com.escodro.savel.data.model.discogs.DiscogsArtist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.spotify.SpotifyArtist;
import com.escodro.savel.data.model.twitter.TwitterTweet;

import java.util.List;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class Artist {

    private final MusicBrainzArtist mMusicBrainzArtist;

    private final DiscogsArtist mDiscogsArtist;

    private final List<TwitterTweet> mTweetList;

    private final SpotifyArtist mSpotifyArtist;

    public Artist(MusicBrainzArtist musicBrainzArtist,
                  DiscogsArtist discogsArtist,
                  List<TwitterTweet> tweetList,
                  SpotifyArtist spotifyArtist) {
        mMusicBrainzArtist = musicBrainzArtist;
        mDiscogsArtist = discogsArtist;
        mTweetList = tweetList;
        mSpotifyArtist = spotifyArtist;
    }

    public Artist(MusicBrainzArtist musicBrainzArtist) {
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

    public List<TwitterTweet> getTweetList() {
        return mTweetList;
    }
}
