package com.escodro.savel.data.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Object containing the consolidated timeline of the artist.
 * <p/>
 * Created by Igor Escodro on 07/06/17.
 */
public class SavelTimeline {

    private List<SavelTweet> mTweetList;

    private List<SavelInstagram> mInstaTimeline;

    private List<SavelFacebook> mFacebookTimeline;

    public SavelTimeline(List<SavelTweet> tweetList,
            List<SavelInstagram> instaTimeline,
            List<SavelFacebook> facebookTimeline) {
        mTweetList = tweetList;
        mInstaTimeline = instaTimeline;
        mFacebookTimeline = facebookTimeline;
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
}
