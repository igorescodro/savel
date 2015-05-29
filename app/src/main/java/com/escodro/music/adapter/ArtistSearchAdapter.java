package com.escodro.music.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestException;
import com.escodro.music.R;
import com.escodro.music.request.ArtistSearchRequest;
import com.escodro.music.request.MusicRequestListener;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link BaseAdapter} to handle the {@link com.escodro.music.activity.ArtistSearchFragment} list.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchAdapter extends BaseAdapter implements MusicRequestListener<List<Artist>> {

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
     * @param context application {@link Context}
     */
    public ArtistSearchAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<Artist>();
        new ArtistSearchRequest(this).execute("Echos");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_artist_search, null);
        }
        try {
            ((TextView) v.findViewById(R.id.artist_name)).setText(mList.get(i).getName());
        } catch (EchoNestException e) {
            e.printStackTrace();
        }
        return v;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestFinished(List<Artist> result) {
        mList = result;
        notifyDataSetChanged();
    }

    /**
     * Class to hold the {@link com.escodro.music.activity.ArtistSearchFragment} views.
     */
    public static class ViewHolder {
        /**
         * {@link ImageView} reference to {@link Artist} thumbnail.
         */
        public ImageView artistThumb;

        /**
         * {@link TextView} reference to {@link Artist} name.
         */
        public TextView artistName;

        /**
         * {@link CheckBox} reference to {@link Artist} favorite.
         */
        public CheckBox artistCheck;

        /**
         * Default constructor to initialize the views.
         *
         * @param view {@link View} with the components
         */
        public ViewHolder(View view) {
            artistThumb = (ImageView) view.findViewById(R.id.artist_thumb);
            artistName = (TextView) view.findViewById(R.id.artist_name);
            artistCheck = (CheckBox) view.findViewById(R.id.artist_check);
        }
    }
}
