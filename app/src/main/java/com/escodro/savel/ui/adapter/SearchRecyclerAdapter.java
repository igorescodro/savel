package com.escodro.savel.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.databinding.ItemArtistSearchBinding;
import com.escodro.savel.ui.viewholder.SearchBindingHolder;
import com.escodro.savel.ui.viewmodel.SearchItemViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * {@link RecyclerView.Adapter} to handle the data on
 * {@link com.escodro.savel.ui.activity.SearchActivity}'s {@link RecyclerView}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchBindingHolder> {

    private final List<Artist> mArtistList;

    @Inject
    Context mContext;

    @Inject
    SearchItemViewModel mViewModel;

    @Inject
    public SearchRecyclerAdapter() {
        mArtistList = new ArrayList<>();
    }

    @Override
    public SearchBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ItemArtistSearchBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_artist_search,
                parent,
                false);

        return new SearchBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(SearchBindingHolder holder, int position) {
        final ItemArtistSearchBinding binding = holder.binding;
        binding.setViewModel(mViewModel);
        mViewModel.setArtist(mArtistList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArtistList.size();
    }

    /**
     * Update the {@link RecyclerView} with the given {@link List}.
     *
     * @param list list of Artists
     */
    public void updateSearchList(List<Artist> list) {
        mArtistList.clear();
        mArtistList.addAll(list);
        notifyDataSetChanged();
    }
}
