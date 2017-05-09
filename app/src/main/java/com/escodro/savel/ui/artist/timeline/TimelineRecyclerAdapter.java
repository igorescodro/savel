package com.escodro.savel.ui.artist.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryType;
import com.escodro.savel.util.viewholder.BindingHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * {@link RecyclerView.Adapter} to handle the data on {@link TimelineFragment}'s
 * {@link RecyclerView} to create a social media timeline, loading different types of
 * {@link TimelineEntryType.EntryType} in the
 * same list.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 *
 * @see
 * <a href="https://medium.com/@matdziu/multiple-row-types-in-recyclerview-2febf66e96a4">Multiple
 * row types in RecyclerView | Medium</a>
 */
public class TimelineRecyclerAdapter extends RecyclerView.Adapter<BindingHolder> {

    private List<TimelineEntryType> mList;

    @Inject
    public TimelineRecyclerAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getItemViewType();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TimelineViewHolderFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        mList.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Update the {@link RecyclerView} with the given {@link List}.
     *
     * @param list list of timeline entries
     */
    public void updateTimelineList(List<TimelineEntryType> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }
}
