package com.escodro.savel.ui.artist.timeline.twitter;

import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.databinding.ItemTimelineTwitterBinding;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryType;
import com.escodro.savel.util.adapter.DateConverter;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * {@link TimelineEntryType} to represent the
 * {@link com.escodro.savel.data.remote.service.TwitterService} entry.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TwitterEntry implements TimelineEntryType {

    private static final String TWITTER_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";

    private SavelTweet mTweet;

    @Inject
    Provider<TwitterItemViewModel> mViewModelProvider;

    @Inject
    DateConverter mDateFormatter;

    @Inject
    public TwitterEntry() {
    }

    @Override
    public int getItemViewType() {
        return TimelineEntryType.TWITTER_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder) {
        final ItemTimelineTwitterBinding binding = (ItemTimelineTwitterBinding) holder.binding;
        final TwitterItemViewModel viewModel = mViewModelProvider.get();
        binding.setViewModel(viewModel);
        viewModel.setTweet(mTweet);
    }

    /**
     * Convert from "{@value TwitterEntry#TWITTER_DATE_FORMAT}" format used by
     * {@link com.escodro.savel.data.remote.service.TwitterService} to milliseconds
     *
     * @return time in milliseconds
     */
    @Override
    public long getEntryTimeInMillis() {
        return mDateFormatter.timeToMillis(mTweet.getCreatedTime(), TWITTER_DATE_FORMAT);
    }

    /**
     * Set the given {@link TwitterTweet} in the current item.
     *
     * @param tweet the Tweet to be set
     */
    public void setTweet(SavelTweet tweet) {
        mTweet = tweet;
    }
}
