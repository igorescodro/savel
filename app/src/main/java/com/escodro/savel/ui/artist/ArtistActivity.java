package com.escodro.savel.ui.artist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.R;
import com.escodro.savel.databinding.ActivityArtistBinding;
import com.escodro.savel.injection.Injector;

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
    ArtistViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        Injector.getApplicationComponent().inject(this);
        final ActivityArtistBinding binding = DataBindingUtil.setContentView(this, R.layout
                .activity_artist);

        mViewModel.setFragmentManager(getSupportFragmentManager());
        binding.setViewModel(mViewModel);

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mViewModel.loadArtist(bundle.getString(EXTRA_ARTIST_ID));
        }
    }
}
