package com.escodro.savel.ui.search;

import android.databinding.ObservableField;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.escodro.savel.data.local.contract.SearchContract;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.databinding.ItemArtistSearchBinding;
import com.escodro.savel.injection.qualifier.LayoutVertical;
import com.escodro.savel.ui.base.NetworkViewModel;
import com.escodro.savel.util.viewholder.BindingHolder;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide information and {@link RecyclerView}-related methods to
 * {@link SearchActivity}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchViewModel extends NetworkViewModel<List<SavelArtist>> {

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
    SearchComparator mSearchComparator;

    @Inject
    @LayoutVertical
    LinearLayoutManager mLayoutManager;

    @Inject
    @LayoutVertical
    DividerItemDecoration mItemDecoration;

    @Inject
    public SearchViewModel() {
        mQuery = new ObservableField<>();
        mRecyclerViewVisibility = new ObservableField<>(View.INVISIBLE);
    }

    @Override
    public Observable<List<SavelArtist>> getObservable() {
        return mContract.searchArtist(mQuery.get());
    }

    @Override
    public void onResult(List<SavelArtist> result) {
        mRecyclerViewVisibility.set(View.VISIBLE);
        Collections.sort(result, mSearchComparator);
        mAdapter.updateSearchList(result);
    }

    public TextView.OnEditorActionListener getOnSearchClicked() {
        return (textView, action, keyEvent) -> {
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                loadData();
                mRecyclerViewVisibility.set(View.INVISIBLE);
            }
            return false;
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
