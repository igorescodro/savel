package com.escodro.music.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.escodro.music.R;
import com.escodro.music.adapter.ArtistSearchAdapter;

/**
 * {@link Fragment} to search {@link com.echonest.api.v4.Artist}
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchFragment extends Fragment {

    public static final String TAG = ArtistSearchFragment.class.getSimpleName();

    public static ArtistSearchFragment newInstance() {
        return new ArtistSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist_search, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArtistSearchAdapter adapter = new ArtistSearchAdapter(
                getActivity().getApplicationContext());
        final ListView listView = (ListView) view.findViewById(R.id.artist_list);
        listView.setAdapter(adapter);
    }
}
