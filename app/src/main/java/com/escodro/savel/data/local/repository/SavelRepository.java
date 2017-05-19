package com.escodro.savel.data.local.repository;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.data.model.SavelFacebook;
import com.escodro.savel.data.model.SavelInstagram;
import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.data.model.facebook.FacebookPost;
import com.escodro.savel.data.model.facebook.FacebookResponse;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.data.model.instagram.InstagramTimeline;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.data.remote.repository.DiscogsRepository;
import com.escodro.savel.data.remote.repository.FacebookRepository;
import com.escodro.savel.data.remote.repository.InstagramRepository;
import com.escodro.savel.data.remote.repository.MusicBrainzRepository;
import com.escodro.savel.data.remote.repository.SpotifyRepository;
import com.escodro.savel.data.remote.repository.TwitterRepository;
import com.escodro.savel.util.adapter.RelationParser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Local repository which wrap the content from every remote service used in the application.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
public class SavelRepository {

    @Inject
    MusicBrainzRepository mMusicBrainzRepository;

    @Inject
    DiscogsRepository mDiscogsRepository;

    @Inject
    TwitterRepository mTwitterRepository;

    @Inject
    SpotifyRepository mSpotifyRepository;

    @Inject
    InstagramRepository mInstaRepository;

    @Inject
    FacebookRepository mFacebookRepository;

    @Inject
    RelationParser mRelationParser;

    @Inject
    public SavelRepository() {
    }

    /**
     * Get the wrapped {@link SavelArtist} from every music service.
     *
     * @param artistId artist MBID
     *
     * @return artist wrapper
     */
    public Observable<SavelArtist> getArtist(String artistId) {
        return mMusicBrainzRepository.getArtistInfo(artistId)
                .flatMap(result -> {
                    mRelationParser.setRelationList(result.getRelations());
                    return Observable.zip(
                            Observable.just(result),
                            mDiscogsRepository.getArtist(mRelationParser.getDiscogsId()),
                            mTwitterRepository.getArtistTimeline(mRelationParser.getTwitterId())
                                    .map(convertToTwitterList()),
                            mSpotifyRepository.getArtistInfo(mRelationParser.getSpotifyId()),
                            mInstaRepository.getArtistTimeline(mRelationParser.getInstagramId())
                                    .map(convertToInstagramList()),
                            mFacebookRepository.getTimeline(mRelationParser.getFacebookId())
                                    .map(convertToFacebookList()),
                            mMusicBrainzRepository.getReleaseGroupByArtistId(artistId),
                            SavelArtist::new);
                });
    }

    /**
     * Get the wrapped {@link List} of {@link SavelArtist} from
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
     *
     * @param artistName artist name
     *
     * @return artist wrapper
     */
    public Observable<List<SavelArtist>> searchArtist(String artistName) {
        return mMusicBrainzRepository.searchArtist(artistName).map(
                musicBrainzArtistList -> {
                    final List<SavelArtist> artists = new ArrayList<>();
                    for (MusicBrainzArtist mbArtist : musicBrainzArtistList.getArtists()) {
                        artists.add(new SavelArtist(mbArtist));
                    }
                    return artists;
                });
    }

    @NonNull
    private Function<InstagramTimeline, List<SavelInstagram>> convertToInstagramList() {
        return instagramTimeline -> {
            final List<SavelInstagram> timeline = new ArrayList<>();
            final List<InstagramItem> items = instagramTimeline.getItems();
            if (items != null) {
                for (InstagramItem item : items) {
                    timeline.add(new SavelInstagram(item));
                }
            }
            return timeline;
        };
    }

    @NonNull
    private Function<List<TwitterTweet>, List<SavelTweet>> convertToTwitterList() {
        return tweetList -> {
            final List<SavelTweet> tweets = new ArrayList<>();
            for (TwitterTweet tweetEntity : tweetList) {
                tweets.add(new SavelTweet(tweetEntity));
            }
            return tweets;
        };
    }

    @NonNull
    private Function<FacebookResponse, List<SavelFacebook>> convertToFacebookList() {
        return facebookTimeline -> {
            final List<SavelFacebook> timeline = new ArrayList<>();
            final List<FacebookPost> items = facebookTimeline.getData();
            if (items != null) {
                for (FacebookPost fbPost : items) {
                    final String userId = mRelationParser.getFacebookId();
                    timeline.add(new SavelFacebook(fbPost, userId));
                }
            }
            return timeline;
        };
    }
}
