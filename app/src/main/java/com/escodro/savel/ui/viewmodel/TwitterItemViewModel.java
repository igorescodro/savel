package com.escodro.savel.ui.viewmodel;

import com.escodro.savel.data.model.twitter.TwitterTweet;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link TwitterTweet} in the view.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TwitterItemViewModel {

    private TwitterTweet mTweet;

    @Inject
    public TwitterItemViewModel() {
    }

    public void setTweet(TwitterTweet tweet) {
        mTweet = tweet;
    }

    public String getText() {
        return mTweet.getText();
    }

    public String getName() {
        return mTweet.getUser().getName();
    }

    public String getProfilePicture() {
        return mTweet.getUser().getProfileImageUrl();
    }
}
