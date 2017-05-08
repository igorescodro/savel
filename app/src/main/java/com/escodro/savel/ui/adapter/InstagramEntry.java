package com.escodro.savel.ui.adapter;

import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.databinding.ItemTimelineInstagramBinding;
import com.escodro.savel.ui.viewmodel.InstagramItemViewModel;
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

    private InstagramItem mInstagramItem;

    @Inject
    public InstagramEntry() {
    }

    @Inject
    Provider<InstagramItemViewModel> mViewModelProvider;

    @Override
    public int getItemViewType() {
        return TimelineEntryType.INSTAGRAM_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder) {
        final ItemTimelineInstagramBinding binding = (ItemTimelineInstagramBinding) holder.binding;
        final InstagramItemViewModel viewModel = mViewModelProvider.get();
        binding.setViewModel(viewModel);
        viewModel.setInstagramItem(mInstagramItem);
    }

    /**
     * Set the given {@link InstagramItem} in the current item.
     *
     * @param instagramItem the Instagram item to be set
     */
    public void setInstagramItem(InstagramItem instagramItem) {
        mInstagramItem = instagramItem;
    }
}
