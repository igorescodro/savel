package com.escodro.music.activity.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import com.escodro.music.MusicApp;
import com.escodro.music.R;
import com.escodro.music.rest.echonest.model.Artist;

/**
 * {@link AppCompatActivity} responsible for the {@link Artist} search.
 * <p/>
 * Created by IgorEscodro on 30/05/15.
 */
public class ArtistSearchActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener {

    /**
     * Constant value to save/retrieve the Query value.
     */
    public static final String ARGS_QUERY = "query";

    /**
     * Start the {@link ArtistSearchActivity}.
     *
     * @param activity {@link Activity} reference
     */
    public static void startActivity(Activity activity) {
        final Intent intent = new Intent(MusicApp.getContext(), ArtistSearchActivity.class);
        activity.startActivity(intent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    /**
     * Inflate the {@link ArtistSearchFragment} passing the parameter ({@link Artist} name) inputted
     * by the user.
     *
     * @param string {@link Artist} name inputted by the user
     *
     * @return false
     */
    @Override
    public boolean onQueryTextSubmit(String string) {
        if (string.length() > 0) {
            final Fragment fragment = ArtistSearchFragment.newInstance();
            final Bundle args = new Bundle();
            args.putString(ARGS_QUERY, string);
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment,
                    ArtistSearchFragment.TAG).commit();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onQueryTextChange(String s) {
        //Do nothing.
        return false;
    }
}
