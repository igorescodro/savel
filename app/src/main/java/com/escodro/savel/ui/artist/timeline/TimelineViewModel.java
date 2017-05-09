package com.escodro.savel.ui.artist.timeline;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryAdapter;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * ViewModel responsible to provide {@link Artist} information to {@link TimelineFragment}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineViewModel {

    @Inject
    TimelineRecyclerAdapter mAdapter;

    @Inject
    Provider<LinearLayoutManager> mLayoutManagerProvider;

    @Inject
    DividerItemDecoration mItemDecoration;

    @Inject
    TimelineEntryAdapter mTimelineAdapter;

    /**
     * Default injectable constructor to be used in {@link TimelineFragment}.
     */
    @Inject
    public TimelineViewModel(ArtistProvider provider) {
        provider.getObservable().subscribe(this::updateTimelineList);
    }

    private void updateTimelineList(Artist artist) {
        mAdapter.updateTimelineList(mTimelineAdapter.extractTimeline(artist));
    }

    public RecyclerView.Adapter<BindingHolder> getRecyclerViewAdapter() {
        return mAdapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return mLayoutManagerProvider.get();
    }

    public DividerItemDecoration getItemDecoration() {
        return mItemDecoration;
    }
}
