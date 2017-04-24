package com.escodro.savel.util.viewholder;

import android.support.v7.widget.RecyclerView;

/**
 * /**
 * Generic {@link RecyclerView.ViewHolder} to be used in {@link RecyclerView.Adapter} and Data
 * Binding.
 *
 * @param <T> type of the binding item
 */
public class BindingHolder<T extends android.databinding.ViewDataBinding> extends
        RecyclerView.ViewHolder {

    /**
     * Binding layout.
     */
    public T binding;

    public BindingHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
