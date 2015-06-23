package com.escodro.savel.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.escodro.savel.MusicApp;
import com.escodro.savel.R;
import com.escodro.savel.activities.ArtistProfileActivity;
import com.escodro.savel.network.spotify.model.Item;
import com.squareup.picasso.Picasso;

/**
 * {@link Fragment} responsible to load {@link Item} data in the views.
 * <p/>
 * Created by IgorEscodro on 14/06/15.
 */
public class ArtistProfileFragment extends Fragment {

    /**
     * {@link Item} reference.
     */
    private Item mItem;

    /**
     * Create a new instance of {@link ArtistProfileFragment}.
     *
     * @param item {@link Item} to be loaded
     *
     * @return new instance of {@link ArtistProfileFragment}
     */
    public static ArtistProfileFragment newInstance(Item item) {
        final ArtistProfileFragment fragment = new ArtistProfileFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(ArtistProfileActivity.ARGS_ITEM, item);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mItem = savedInstanceState.getParcelable(ArtistProfileActivity.ARGS_ITEM);
        } else {
            mItem = getArguments().getParcelable(ArtistProfileActivity.ARGS_ITEM);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ArtistProfileActivity.ARGS_ITEM, mItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadItem(view);
    }

    /**
     * Load {@link Item} data in the views.
     *
     * @param view {@link View} with the components
     */
    private void loadItem(View view) {
        final ImageView imageView = (ImageView) view.findViewById(R.id.artist_header);
        Picasso.with(MusicApp.getContext())
                .load(mItem.getImages().get(1).getUrl())
                .fit()
                .centerCrop()
                .into(imageView);
    }
}
