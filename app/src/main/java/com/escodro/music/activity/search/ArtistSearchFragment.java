package com.escodro.music.activity.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.escodro.music.MusicApp;
import com.escodro.music.R;
import com.escodro.music.rest.echonest.EchoNestAPI;
import com.escodro.music.rest.echonest.model.Artist;
import com.escodro.music.rest.spotify.model.SpotifyResponse;
import com.escodro.music.rest.spotify.model.Type;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * {@link Fragment} responsible to inflate the layout and request the data to the {@link
 * EchoNestAPI}
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchFragment extends Fragment implements Callback<SpotifyResponse> {

    /**
     * {@link ArtistSearchFragment} Tag.
     */
    public static final String TAG = ArtistSearchFragment.class.getSimpleName();

    /**
     * {@link ListView} reference.
     */
    private ListView mListView;

    /**
     * Creates a new instance of {@link ArtistSearchFragment}.
     *
     * @return new instance of {@link ArtistSearchFragment}
     */
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
        final String query = getArguments().getString(ArtistSearchActivity.ARGS_QUERY);
        initComponents(view);
        createRequest(query);
    }

    /**
     * Initialize the layout components;.
     *
     * @param view {@link View} with the components
     */
    private void initComponents(View view) {
        final TextView emptyView = (TextView) view.findViewById(R.id.empty_list);
        mListView = (ListView) view.findViewById(R.id.artist_list);
        mListView.setEmptyView(emptyView);
    }

    /**
     * Creates and handles the {@link EchoNestAPI} request to search an {@link Artist} based on user
     * input.
     *
     * @param query {@link Artist} name
     */
    private void createRequest(String query) {
        MusicApp.getSpotifyAPI().searchItemByName(query, Type.ARTIST.toString(), this);
    }

    @Override
    public void success(SpotifyResponse artists, Response response) {
        final ArtistSearchAdapter adapter = new ArtistSearchAdapter(
                artists.getArtists().getItems());
        mListView.setAdapter(adapter);
    }

    @Override
    public void failure(RetrofitError error) {
        //Do nothing.
    }
}
