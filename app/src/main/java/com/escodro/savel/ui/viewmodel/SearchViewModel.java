package com.escodro.savel.ui.viewmodel;

import android.databinding.ObservableField;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.escodro.savel.data.local.contract.SearchContract;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.databinding.ItemArtistSearchBinding;
import com.escodro.savel.ui.adapter.SearchRecyclerAdapter;
import com.escodro.savel.util.viewholder.BindingHolder;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide information and {@link RecyclerView}-related methods to
 * {@link com.escodro.savel.ui.activity.SearchActivity}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchViewModel extends NetworkViewModel<List<Artist>> {

    /**
     * Two-way binding {@link ObservableField} to handle user input query.
     */
    public final ObservableField<String> mQuery;

    /**
     * {@link ObservableField} to provide the {@link RecyclerView} visibility. This field is
     * needed once the {@link RecyclerView} will appear in front of included layout every time.
     */
    public final ObservableField<Integer> mRecyclerViewVisibility;

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
        mRecyclerViewVisibility = new ObservableField<>(View.INVISIBLE);
    }

    @Override
    public Observable<List<Artist>> getObservable() {
        return mContract.searchArtist(mQuery.get());
    }

    @Override
    public void onResult(List<Artist> result) {
        mRecyclerViewVisibility.set(View.VISIBLE);
        mAdapter.updateSearchList(result);
    }

    public View.OnClickListener getSearchClickListener() {
        return view -> {
            loadData();
            mRecyclerViewVisibility.set(View.INVISIBLE);
        };
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
}
