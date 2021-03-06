package com.escodro.savel.ui.artist.timeline;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.escodro.savel.data.local.provider.TimelineProvider;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.data.model.SavelTimeline;
import com.escodro.savel.injection.qualifier.LayoutVertical;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryAdapter;
import com.escodro.savel.ui.base.NetworkViewModel;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observable;

/**
 * ViewModel responsible to provide {@link SavelArtist} information to {@link TimelineFragment}.
 * <p/>
 * Created by Igor Escodro on 06/05/17.
 */
public class TimelineViewModel extends NetworkViewModel<SavelTimeline> {

    private TimelineProvider mTimelineProvider;

    @Inject
    TimelineRecyclerAdapter mAdapter;

    @Inject
    @LayoutVertical
    Provider<LinearLayoutManager> mLayoutManagerProvider;

    @Inject
    @LayoutVertical
    DividerItemDecoration mItemDecoration;

    @Inject
    TimelineEntryAdapter mTimelineAdapter;

    /**
     * Default injectable constructor to be used in {@link TimelineFragment}.
     */
    @Inject
    public TimelineViewModel(TimelineProvider provider) {
        mTimelineProvider = provider;
        loadData();
    }

    @Override
    public Observable<SavelTimeline> getObservable() {
        return mTimelineProvider.getObservable();
    }

    @Override
    public void onResult(SavelTimeline timeline) {
        mAdapter.updateTimelineList(mTimelineAdapter.extractTimeline(timeline));
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
