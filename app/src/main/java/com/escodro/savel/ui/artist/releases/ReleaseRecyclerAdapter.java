package com.escodro.savel.ui.artist.releases;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.data.model.SavelRelease;
import com.escodro.savel.databinding.ItemArtistReleaseBinding;
import com.escodro.savel.util.viewholder.BindingHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * {@link RecyclerView.Adapter} to handle the data on {@link ReleaseFragment}'s {@link
 * RecyclerView}.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class ReleaseRecyclerAdapter extends
        RecyclerView.Adapter<BindingHolder<ItemArtistReleaseBinding>> {

    private final List<SavelRelease> mReleaseList;

    private Context mContext;

    @Inject
    Provider<ReleaseItemViewModel> mViewModelProvider;

    @Inject
    public ReleaseRecyclerAdapter(Context context) {
        mContext = context;
        mReleaseList = new ArrayList<>();
    }

    @Override
    public BindingHolder<ItemArtistReleaseBinding> onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        final ItemArtistReleaseBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_artist_release,
                parent,
                false);
        return new BindingHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder<ItemArtistReleaseBinding> holder, int position) {
        final ItemArtistReleaseBinding binding = holder.binding;
        final ReleaseItemViewModel viewModel = mViewModelProvider.get();
        binding.setViewModel(viewModel);
        viewModel.setRelease(mReleaseList.get(position));
    }

    @Override
    public int getItemCount() {
        return mReleaseList.size();
    }

    /**
     * Update the {@link RecyclerView} with the given {@link List}.
     *
     * @param list list of releases
     */
    public void updateReleaseList(List<SavelRelease> list) {
        mReleaseList.clear();
        mReleaseList.addAll(list);
        notifyDataSetChanged();
    }
}
