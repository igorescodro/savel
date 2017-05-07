package com.escodro.savel.ui.adapter;

import com.escodro.savel.data.model.twitter.TwitterTweet;
import com.escodro.savel.databinding.ItemTimelineTwitterBinding;
import com.escodro.savel.ui.viewmodel.TwitterItemViewModel;
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

    private TwitterTweet mTwitterTweet;

    @Inject
    Provider<TwitterItemViewModel> mViewModelProvider;

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
        viewModel.setTweet(mTwitterTweet);
    }

    /**
     * Set the given {@link TwitterTweet} in the current item.
     *
     * @param twitterTweet the Tweet to be set
     */
    public void setTwitterTweet(TwitterTweet twitterTweet) {
        mTwitterTweet = twitterTweet;
    }
}
