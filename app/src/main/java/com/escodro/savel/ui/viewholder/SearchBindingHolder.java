package com.escodro.savel.ui.viewholder;

import android.support.v7.widget.RecyclerView;

import com.escodro.savel.databinding.ItemArtistSearchBinding;

/**
 * {@link RecyclerView.ViewHolder} related to {@link ItemArtistSearchBinding}.
 */
public class SearchBindingHolder extends RecyclerView.ViewHolder {

    /**
     * Binding layout.
     */
    public ItemArtistSearchBinding binding;

    public SearchBindingHolder(ItemArtistSearchBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
