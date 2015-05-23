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
import com.escodro.music.R;
import com.escodro.music.request.MusicRequestListener;

import java.util.List;

/**
 * {@link BaseAdapter} to handle the {@link com.escodro.music.activity.ArtistSearchFragment} list.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchAdapter extends BaseAdapter implements MusicRequestListener<List<Artist>> {

    private final Context mContext;

    public ArtistSearchAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int i) {
        return new Object();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.item_artist_search, null);
    }

    @Override
    public void onRequestFinished(List<Artist> params) {

    }

    public static class ViewHolder {
        public ImageView artistThumb;
        public TextView artistName;
        public CheckBox artistCheck;

        public ViewHolder(View view) {
            artistThumb = (ImageView) view.findViewById(R.id.artist_thumb);
            artistName = (TextView) view.findViewById(R.id.artist_name);
            artistCheck = (CheckBox) view.findViewById(R.id.artist_check);
        }
    }
}
