package com.escodro.savel.ui.artist.timeline.twitter;

import android.support.annotation.NonNull;
import android.view.View;

import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.ui.base.TimelineEntryViewModel;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link TwitterTweet} in the view.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TwitterItemViewModel extends TimelineEntryViewModel {

    private static final String BASE_STATUS_URL = "http://twitter.com/";

    private static final String STATUS_PATH = "/status/";

    private SavelTweet mTweet;

    private boolean isRetweet;

    private String mTimelineUser;

    @Inject
    public TwitterItemViewModel() {
    }

    public void setTweet(@NonNull SavelTweet tweet) {
        if (tweet.isRetweet()) {
            mTweet = tweet.getRetweet();
            mTimelineUser = tweet.getUsername();
            isRetweet = true;
        } else {
            mTweet = tweet;
        }
    }

    public String getText() {
        return mTweet.getText();
    }

    public String getName() {
        return mTweet.getUsername();
    }

    public String getTimelineUser() {
        return mTimelineUser;
    }

    public String getProfilePicture() {
        return mTweet.getProfileImageUrl();
    }

    public String getCreationTime() {
        return getRelativeDateTimeString(mTweet.getCreatedTime());
    }

    public int getRetweetVisibility() {
        int visibility = View.GONE;
        if (isRetweet) {
            visibility = View.VISIBLE;
        }
        return visibility;
    }

    /**
     * Builds the {@link com.escodro.savel.data.remote.service.TwitterService} status url once the
     * endpoint does not provides it.<br>
     * The status url is formed by the {@value TwitterItemViewModel#BASE_STATUS_URL} + USERNAME +
     * {@value TwitterItemViewModel#STATUS_PATH} + TWEET ID,
     * e.g. https://twitter.com/fosterthepeople/status/857640531354042368
     *
     * @return entry url
     */
    @Override
    protected String getEntryUrl() {
        final String username = mTweet.getScreenName();
        final String tweetId = mTweet.getId();
        return BASE_STATUS_URL + username + STATUS_PATH + tweetId;
    }

    public int getVideoIconVisibility() {
        return mTweet.isPlayable() ? View.VISIBLE : View.GONE;
    }

    public int getMediaImageVisibility() {
        return mTweet.hasMedia() ? View.VISIBLE : View.GONE;
    }

    public String getImage() {
        return mTweet.getMediaThumbnail();
    }
}
