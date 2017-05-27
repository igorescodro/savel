package com.escodro.savel.ui.artist.timeline.facebook;

import com.escodro.savel.data.model.SavelFacebook;
import com.escodro.savel.databinding.ItemTimelineFacebookBinding;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryType;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * {@link TimelineEntryType} to represent the
 * {@link com.escodro.savel.data.remote.service.FacebookService} entry.
 * <p/>
 * Created by Igor Escodro on 15/05/17.
 */
public class FacebookEntry implements TimelineEntryType {

    private SavelFacebook mFacebookItem;

    @Inject
    Provider<FacebookItemViewModel> mViewModelProvider;

    @Inject
    public FacebookEntry() {
    }

    @Override
    public int getItemViewType() {
        return FACEBOOK_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder) {
        final ItemTimelineFacebookBinding binding = (ItemTimelineFacebookBinding) holder.binding;
        final FacebookItemViewModel viewModel = mViewModelProvider.get();
        binding.setViewModel(viewModel);
        viewModel.setFacebookItem(mFacebookItem);

    }

    @Override
    public long getEntryTimeInMillis() {
        long timeInMillis = 0L;
        if (mFacebookItem != null) {
            timeInMillis = mFacebookItem.getCreatedTime();
        }
        return timeInMillis;
    }

    public void setFacebookItem(SavelFacebook facebookItem) {
        mFacebookItem = facebookItem;
    }
}
