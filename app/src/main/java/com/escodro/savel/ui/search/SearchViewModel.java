package com.escodro.savel.ui.search;

import android.databinding.ObservableField;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.escodro.savel.data.local.contract.SearchContract;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.databinding.ItemArtistSearchBinding;
import com.escodro.savel.ui.base.NetworkViewModel;
import com.escodro.savel.util.viewholder.BindingHolder;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide information and {@link RecyclerView}-related methods to
 * {@link SearchActivity}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchViewModel extends NetworkViewModel<List<Artist>> implements Comparator<Artist> {

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
        result.sort(this);
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

    /**
     * Custom comparator to send all the {@link Artist}s without {@link Artist#getArea()} to the
     * bottom of the list. This is needed once
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService} does not have a nice
     * implementation of popularity and less famous artists can appear on top. Usually more
     * famous artists have a better description (like {@link Artist#getArea()}.
     *
     * @param t0 first artist to compare
     * @param t1 second artist to compare
     *
     * @return relegation of {@link Artist} with <code>null</code> {@link Artist#getArea()}
     */
    @Override
    public int compare(Artist t0, Artist t1) {
        if (TextUtils.equals(t0.getArea(), t1.getArea())) {
            return 0;
        }
        if (t0.getArea() == null) {
            return 1;
        }
        if (t1.getArea() == null) {
            return -1;
        }
        return 0;
    }
}
