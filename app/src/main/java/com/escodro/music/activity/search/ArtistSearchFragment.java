package com.escodro.music.activity.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.escodro.music.MusicApp;
import com.escodro.music.R;
import com.escodro.music.rest.echonest.model.EchoNestResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * {@link Fragment} responsible to inflate the layout and request the data to the {@link
 * com.escodro.music.rest.echonest.EchoNestAPI}
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class ArtistSearchFragment extends Fragment {

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
        mListView = (ListView) view.findViewById(R.id.artist_list);
        final String query = getArguments().getString(ArtistSearchActivity.ARGS_QUERY);
        createRequest(query);
    }

    /**
     * Creates and handles the {@link com.escodro.music.rest.echonest.EchoNestAPI} request to search
     * an {@link com.escodro.music.rest.echonest.model.Artist} based on user input.
     *
     * @param query {@link com.escodro.music.rest.echonest.model.Artist} name
     */
    private void createRequest(String query) {
        MusicApp.getEchoNestAPI()
                .searchArtistByName(query, 50, new Callback<EchoNestResponse>() {
                    @Override
                    public void success(EchoNestResponse artists, Response response) {
                        final ArtistSearchAdapter adapter = new ArtistSearchAdapter(artists
                                .getResponse().getArtists());
                        mListView.setAdapter(adapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println(error.getBody());
                    }
                });
    }
}
