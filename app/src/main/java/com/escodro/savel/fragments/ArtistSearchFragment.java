package com.escodro.savel.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.escodro.savel.R;
import com.escodro.savel.SavelApp;
import com.escodro.savel.activities.ArtistSearchActivity;
import com.escodro.savel.adapters.ArtistSearchAdapter;
import com.escodro.savel.network.echonest.EchoNestAPI;
import com.escodro.savel.network.echonest.model.Artist;
import com.escodro.savel.network.spotify.enums.Type;
import com.escodro.savel.network.spotify.model.Item;
import com.escodro.savel.network.spotify.model.SpotifyResponse;

import java.util.List;

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
    private RecyclerView mRecyclerView;

    /**
     * {@link ProgressBar} reference to be shown when the search is loading.
     */
    private ProgressBar mProgressBarLoading;

    /**
     * {@link TextView} reference to be shown when the search is loading.
     */
    private TextView mTextViewLoading;

    /**
     * {@link TextView} reference to be shown when there is no artist found.
     */
    private TextView mTextViewEmpty;

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
        mRecyclerView = (RecyclerView) view.findViewById(R.id.artist_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(SavelApp.getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProgressBarLoading = (ProgressBar) view.findViewById(R.id.progress_bar_loading);
        mTextViewLoading = (TextView) view.findViewById(R.id.text_view_loading);
        mTextViewEmpty = (TextView) view.findViewById(R.id.text_view_empty);
    }

    /**
     * When the request is successful, it change the visibility of some components, depending of the
     * number of {@link Item}s found.
     *
     * @param listSize number of {@Item}s found
     */
    private void onSuccess(int listSize) {
        mProgressBarLoading.setVisibility(View.INVISIBLE);
        mTextViewLoading.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
        if (listSize == 0) {
            mTextViewEmpty.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Creates and handles the {@link EchoNestAPI} request to search an {@link Artist} based on user
     * input.
     *
     * @param query {@link Artist} name
     */
    private void createRequest(String query) {
        SavelApp.getSpotifyAPI().searchItemByName("*" + query + "*", Type.ARTIST.toString(), this);
    }

    @Override
    public void success(SpotifyResponse artists, Response response) {
        final List<Item> items = artists.getArtists().getItems();
        final ArtistSearchAdapter mAdapter = new ArtistSearchAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        onSuccess(items.size());
    }

    @Override
    public void failure(RetrofitError error) {
        //Do nothing.
    }
}
