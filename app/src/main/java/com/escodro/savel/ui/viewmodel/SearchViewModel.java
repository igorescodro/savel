package com.escodro.savel.ui.viewmodel;

import android.databinding.ObservableField;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.escodro.savel.data.local.contract.SearchContract;
import com.escodro.savel.databinding.ItemArtistSearchBinding;
import com.escodro.savel.ui.adapter.SearchRecyclerAdapter;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide information and {@link RecyclerView}-related methods to
 * {@link com.escodro.savel.ui.activity.SearchActivity}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchViewModel {

    /**
     * Two-way binding {@link ObservableField} to handle user input query.
     */
    public final ObservableField<String> mQuery;

    @Inject
    SearchContract mContract;

    @Inject
    SearchRecyclerAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    DividerItemDecoration mItemDecoration;

    @Inject
    public SearchViewModel() {
        mQuery = new ObservableField<>();
    }

    public View.OnClickListener getSearchClickListener() {
        return view -> searchAndUpdateList(mQuery.get());
    }

    public RecyclerView.Adapter<BindingHolder<ItemArtistSearchBinding>> getRecyclerViewAdapter() {
        return mAdapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return mLayoutManager;
    }

    public DividerItemDecoration getItemDecoration() {
        return mItemDecoration;
    }

    private void searchAndUpdateList(String artistName) {
        mContract.searchArtist(artistName).subscribe(artists -> mAdapter.updateSearchList(artists));
    }
}
