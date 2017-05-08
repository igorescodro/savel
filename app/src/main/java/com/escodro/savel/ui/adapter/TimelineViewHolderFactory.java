package com.escodro.savel.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.escodro.savel.R;
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
        ViewDataBinding binding = null;
        switch (viewType) {
            case TimelineEntryType.TWITTER_ROW_TYPE:
                binding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_timeline_twitter,
                        parent,
                        false);
                break;
            case TimelineEntryType.INSTAGRAM_ROW_TYPE:
                binding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_timeline_instagram,
                        parent,
                        false);
                break;
        }

        return new BindingHolder<>(binding);
    }
}
