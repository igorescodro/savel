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

    /**
     * {@link ArtistSearchFragment} Tag.
     */
    public static final String TAG = ArtistSearchFragment.class.getSimpleName();

    /**
     * Creates a new instance of {@link ArtistSearchFragment}.
     *
     * @return new instance of {@link ArtistSearchFragment}
     */
    public static ArtistSearchFragment newInstance() {
        return new ArtistSearchFragment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist_search, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ListView mListView = (ListView) view.findViewById(R.id.artist_list);
        final ArtistSearchAdapter adapter = new ArtistSearchAdapter(
                getActivity().getApplicationContext());
        mListView.setAdapter(adapter);
    }
}
