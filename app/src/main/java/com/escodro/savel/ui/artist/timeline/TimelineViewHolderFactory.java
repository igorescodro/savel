package com.escodro.savel.ui.artist.timeline;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.ui.artist.timeline.entry.TimelineEntryType;
import com.escodro.savel.util.viewholder.BindingHolder;

/**
 * Factory to build an {@link BindingHolder} based on the given {@link TimelineEntryType.EntryType}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineViewHolderFactory {

    /**
     * Return an {@link BindingHolder} based on the given {@link TimelineEntryType.EntryType}.
     *
     * @param parent   the ViewGroup parent
     * @param viewType the timeline row type
     *
     * @return the built BindingHolder
     */
    public static BindingHolder create(ViewGroup parent,
                                       @TimelineEntryType.EntryType int viewType) {
        final int layoutRes;
        switch (viewType) {
            case TimelineEntryType.TWITTER_ROW_TYPE:
                layoutRes = R.layout.item_timeline_twitter;
                break;
            case TimelineEntryType.INSTAGRAM_ROW_TYPE:
                layoutRes = R.layout.item_timeline_instagram;
                break;
            case TimelineEntryType.FACEBOOK_ROW_TYPE:
                layoutRes = R.layout.item_timeline_facebook;
                break;
            default:
                layoutRes = android.R.layout.simple_list_item_1;
        }

        final ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                layoutRes,
                parent,
                false);

        return new BindingHolder<>(binding);
    }
}
