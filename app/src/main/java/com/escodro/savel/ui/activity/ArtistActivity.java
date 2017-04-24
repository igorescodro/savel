package com.escodro.savel.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.R;
import com.escodro.savel.injection.Injector;
import com.escodro.savel.ui.fragment.ArtistFragment;

import javax.inject.Inject;

/**
 * {@link AppCompatActivity} with the display information about
 * {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistActivity extends AppCompatActivity {

    public static final String EXTRA_ARTIST_ID = "artist_id";

    @Inject
    ArtistFragment mArtistFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        Injector.getApplicationComponent().inject(this);

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            addArtistFragment(bundle.getString(EXTRA_ARTIST_ID));
        }
    }

    private void addArtistFragment(String artistId) {
        final Bundle bundle = new Bundle();
        bundle.putString(EXTRA_ARTIST_ID, artistId);
        mArtistFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, mArtistFragment)
                .commit();
    }
}
