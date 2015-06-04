package com.escodro.music.activity.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.escodro.music.MusicApp;
import com.escodro.music.R;
import com.escodro.music.rest.echonest.model.Artist;
import com.escodro.music.view.BlurTransformation;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link BaseAdapter} to handle the {@link ArtistSearchFragment} list.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchAdapter extends BaseAdapter {

    /**
     * Application {@link Context}.
     */
    private final Context mContext;

    /**
     * {@link List} of {@link Artist}.
     */
    private List<Artist> mList;

    /**
     * Creates a new instance of {@link ArtistSearchAdapter}.
     *
     * @param artists artists {@link List}
     */
    public ArtistSearchAdapter(List<Artist> artists) {
        mContext = MusicApp.getContext();
        mList = artists;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_artist_search, null);
        }
        final ViewHolder holder = new ViewHolder(view);
        final Artist artist = mList.get(i);
        holder.artistName.setText(artist.getName());
        loadArtistImage(artist, holder);
        return view;
    }

    /**
     * Load the {@link Artist} image or the placeholder using {@link Picasso}.
     *
     * @param artist {@link Artist} reference
     * @param holder {@link ViewHolder} reference
     */
    private void loadArtistImage(Artist artist, final ViewHolder holder) {
        if (!artist.getImages().isEmpty()) {
            holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(MusicApp.getContext())
                    .load(artist.getImages().get(0).getUrl())
                    .fit()
                    .centerCrop()
                    .transform(new BlurTransformation())
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
     * Class to hold the {@link ArtistSearchFragment} views.
     */
    public static class ViewHolder {
        /**
         * {@link ImageView} reference to {@link Artist} thumbnail.
         */
        public final ImageView artistThumb;

        /**
         * {@link TextView} reference to {@link Artist} name.
         */
        public final TextView artistName;

        /**
         * {@link ProgressBar} reference.
         */
        public final ProgressBar progressBar;

        /**
         * Default constructor to initialize the views.
         *
         * @param view {@link View} with the components
         */
        public ViewHolder(View view) {
            artistThumb = (ImageView) view.findViewById(R.id.artist_thumb);
            artistName = (TextView) view.findViewById(R.id.artist_name);
            progressBar = (ProgressBar) view.findViewById(R.id.loading);
        }
    }
}
