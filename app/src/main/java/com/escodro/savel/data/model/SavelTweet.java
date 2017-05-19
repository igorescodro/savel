package com.escodro.savel.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.util.adapter.DateConverter;

/**
 * Object to represent the {@link com.escodro.savel.data.remote.service.TwitterService} tweet.
 * The intent of this object is to better encapsulate the fields and contains only relative
 * information.
 * <p/>
 * Created by Igor Escodro on 10/05/17.
 */
public class SavelTweet {

    private static final String TWITTER_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";

    private final TwitterTweet mTweetEntity;

    public SavelTweet(@NonNull TwitterTweet tweetEntity) {
        mTweetEntity = tweetEntity;
    }

    public long getCreatedTime() {
        long creationDate = 0;
        if (mTweetEntity.getCreatedTime() != null) {
            creationDate = DateConverter
                    .timeToMillis(mTweetEntity.getCreatedTime(), TWITTER_DATE_FORMAT);
        }
        return creationDate;
    }

    @Nullable
    public String getId() {
        return mTweetEntity.getId();
    }

    @Nullable
    public String getUsername() {
        return mTweetEntity.getUserName();
    }

    @Nullable
    public String getScreenName() {
        return mTweetEntity.getScreenName();
    }

    @Nullable
    public String getProfileImageUrl() {
        return mTweetEntity.getProfileImageUrl();
    }

    @Nullable
    public String getText() {
        return mTweetEntity.getText();
    }

    public boolean isRetweet() {
        return mTweetEntity.isRetweet();
    }

    @Nullable
    public SavelTweet getRetweet() {
        SavelTweet tweet = null;
        if (mTweetEntity.getRetweet() != null) {
            tweet = new SavelTweet(mTweetEntity.getRetweet());
        }
        return tweet;
    }
}
