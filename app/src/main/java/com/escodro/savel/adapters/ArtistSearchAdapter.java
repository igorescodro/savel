package com.escodro.savel.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.escodro.savel.MusicApp;
import com.escodro.savel.R;
import com.escodro.savel.activities.ArtistProfileActivity;
import com.escodro.savel.fragments.ArtistSearchFragment;
import com.escodro.savel.interfaces.OnItemClickListener;
import com.escodro.savel.network.spotify.model.Item;
import com.escodro.savel.views.BlurTransformation;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} to handle the {@link ArtistSearchFragment} list.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchAdapter extends RecyclerView.Adapter<ArtistSearchAdapter.ViewHolder>
        implements OnItemClickListener {

    /**
     * {@link List} of {@link Item}.
     */
    private List<Item> mList;

    /**
     * Creates a new instance of {@link ArtistSearchAdapter}.
     *
     * @param artists artists {@link List}
     */
    public ArtistSearchAdapter(List<Item> artists) {
        mList = artists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_artist_search, viewGroup, false);
        return new ViewHolder(itemLayoutView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Item artist = mList.get(i);
        viewHolder.artistName.setText(artist.getName());
        loadArtistImage(artist, viewHolder);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Load the {@link Item} image or the placeholder using {@link Picasso}.
     *
     * @param artist {@link Item} reference
     * @param holder {@link ViewHolder} reference
     */
    private void loadArtistImage(Item artist, final ViewHolder holder) {
        if (!artist.getImages().isEmpty()) {
            holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(MusicApp.getContext())
                    .load(artist.getImages().get(1).getUrl())
                    .fit()
                    .centerCrop()
                    .into(holder.artistThumb, new Callback() {
                        @Override
                        public void onSuccess() {
                            holder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            //Do nothing.
                        }
                    });
        } else {
            holder.progressBar.setVisibility(View.GONE);
            Picasso.with(MusicApp.getContext()).load(R.drawable.artist_placeholder)
                    .fit()
                    .centerCrop()
                    .transform(new BlurTransformation())
                    .into(holder.artistThumb);
        }
    }

    /**
     * Start {@link ArtistProfileActivity} with the selected {@link Item} when an item is clicked.
     *
     * @param view     {@link View} clicked
     * @param position item position
     */
    @Override
    public void onItemClick(View view, int position) {
        ArtistProfileActivity.startActivity(mList.get(position));
    }

    /**
     * Class to hold the {@link ArtistSearchFragment} views.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * {@link ImageView} reference to {@link Item} thumbnail.
         */
        public final ImageView artistThumb;
        /**
         * {@link TextView} reference to {@link Item} name.
         */
        public final TextView artistName;
        /**
         * {@link ProgressBar} reference.
         */
        public final ProgressBar progressBar;
        /**
         * {@link OnItemClickListener} reference.
         */
        private final OnItemClickListener mListener;
        /**
         * {@link RelativeLayout} reference, containing all the views.
         */
        public RelativeLayout itemLayout;

        /**
         * Default constructor to initialize the views.
         *
         * @param view     {@link View} with the components
         * @param listener {@link OnItemClickListener} reference
         */
        public ViewHolder(View view, OnItemClickListener listener) {
            super(view);
            mListener = listener;
            itemLayout = (RelativeLayout) view.findViewById(R.id.item_layout);
            artistThumb = (ImageView) view.findViewById(R.id.artist_thumb);
            artistName = (TextView) view.findViewById(R.id.artist_name);
            progressBar = (ProgressBar) view.findViewById(R.id.loading);
            itemLayout.setOnClickListener(this);
        }

        /**
         * Override the {@code OnClick} to handle the click on each {@link View} of the {@link
         * ViewHolder}.
         *
         * @param view {@link View} clicked
         */
        @Override
        public void onClick(View view) {
            mListener.onItemClick(view, getAdapterPosition());
        }
    }
}
