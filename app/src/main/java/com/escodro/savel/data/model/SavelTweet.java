package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.util.adapter.DateConverter;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Object to represent the {@link com.escodro.savel.data.remote.service.TwitterService} tweet.
 * The intent of this object is to better encapsulate the fields and contains only relative
 * information.
 * <p/>
 * Created by Igor Escodro on 10/05/17.
 */
public class SavelTweet {

    private static final String TWITTER_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";

    private TwitterTweet mTweetEntity;

    @Inject
    Provider<SavelTweet> mRetweetProvider;

    @Inject
    public SavelTweet() {
    }

    public void setTweetEntity(@NonNull TwitterTweet tweetEntity) {
        mTweetEntity = tweetEntity;
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mTweetEntity != null && mTweetEntity.getCreatedTime() != null) {
            creationDate = DateConverter
                    .timeToMillis(mTweetEntity.getCreatedTime(), TWITTER_DATE_FORMAT);
        }
        return creationDate;
    }

    @Nullable
    public String getId() {
        String username = null;
        if (mTweetEntity != null) {
            username = mTweetEntity.getId();
        }
        return username;
    }

    @Nullable
    public String getUsername() {
        String username = null;
        if (mTweetEntity != null) {
            username = mTweetEntity.getUserName();
        }
        return username;
    }

    @Nullable
    public String getScreenName() {
        String screenName = null;
        if (mTweetEntity != null) {
            screenName = mTweetEntity.getScreenName();
        }
        return screenName;
    }

    @Nullable
    public String getProfileImageUrl() {
        String username = null;
        if (mTweetEntity != null) {
            username = mTweetEntity.getProfileImageUrl();
        }
        return username;
    }

    @Nullable
    public String getText() {
        String username = null;
        if (mTweetEntity != null) {
            username = mTweetEntity.getText();
        }
        return username;
    }

    public boolean isRetweet() {
        boolean isRetweet = false;
        if (mTweetEntity != null) {
            isRetweet = mTweetEntity.isRetweet();
        }
        return isRetweet;
    }

    @Nullable
    public SavelTweet getRetweet() {
        final SavelTweet tweet = mRetweetProvider.get();
        if (mTweetEntity != null && mTweetEntity.getRetweet() != null) {
            tweet.setTweetEntity(mTweetEntity.getRetweet());
        }
        return tweet;
    }
}
