package com.escodro.savel.ui.artist;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.R;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.databinding.ActivityArtistBinding;
import com.escodro.savel.injection.Injector;

import javax.inject.Inject;

/**
 * {@link AppCompatActivity} with the display information about {@link SavelArtist}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class ArtistActivity extends AppCompatActivity {

    private static final String EXTRA_ARTIST_ID = "artist_id";

    @Inject
    ArtistViewModel mViewModel;

    public static void startActivity(Context context, String artistId) {
        final Intent intent = new Intent(context, ArtistActivity.class);
        intent.putExtra(ArtistActivity.EXTRA_ARTIST_ID, artistId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

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
