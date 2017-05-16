package com.escodro.savel.ui.artist.timeline.instagram;

import com.escodro.savel.data.model.SavelInstagram;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.databinding.ItemTimelineInstagramBinding;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryType;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * {@link TimelineEntryType} to represent the
 * {@link com.escodro.savel.data.remote.service.InstagramService} entry.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class InstagramEntry implements TimelineEntryType {

    private SavelInstagram mInstagramItem;

    @Inject
    Provider<InstagramItemViewModel> mViewModelProvider;

    @Inject
    public InstagramEntry() {
    }

    @Override
    public int getItemViewType() {
        return INSTAGRAM_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder) {
        final ItemTimelineInstagramBinding binding = (ItemTimelineInstagramBinding) holder.binding;
        final InstagramItemViewModel viewModel = mViewModelProvider.get();
        binding.setViewModel(viewModel);
        viewModel.setInstagramItem(mInstagramItem);
    }

    /**
     * Convert from Unix Timestamp used by
     * {@link com.escodro.savel.data.remote.service.InstagramService} to milliseconds
     *
     * @return time in milliseconds
     */
    @Override
    public long getEntryTimeInMillis() {
        return mInstagramItem.getCreatedTime();
    }

    /**
     * Set the given {@link InstagramItem} in the current item.
     *
     * @param instagramItem the Instagram item to be set
     */
    public void setInstagramItem(SavelInstagram instagramItem) {
        mInstagramItem = instagramItem;
    }
}
