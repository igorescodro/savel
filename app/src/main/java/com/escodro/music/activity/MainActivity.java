package com.escodro.music.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.escodro.music.R;

/**
 * Main {@link android.app.Activity} of Music Project application.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, ArtistSearchFragment.newInstance(),
                        ArtistSearchFragment.TAG).commit();
    }
}
