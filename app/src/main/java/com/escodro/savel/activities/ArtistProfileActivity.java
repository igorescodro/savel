package com.escodro.savel.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.MusicApp;
import com.escodro.savel.fragments.ArtistProfileFragment;
import com.escodro.savel.network.spotify.model.Item;

/**
 * {@link AppCompatActivity} responsible to show {@link Item} profile information.
 * <p/>
 * Created by IgorEscodro on 14/06/15.
 */
public class ArtistProfileActivity extends AppCompatActivity {

    /**
     * Constant value to save/retrieve the {@link Item}.
     */
    public static final String ARGS_ITEM = "item";

    /**
     * Start {@link ArtistProfileActivity}.
     *
     * @param item {@link Item} to be shown
     */
    public static void startActivity(Item item) {
        final Context context = MusicApp.getContext();
        final Intent intent = new Intent(context, ArtistProfileActivity.class);
        intent.putExtra(ARGS_ITEM, item);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Item item = extras.getParcelable(ARGS_ITEM);
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content,
                    ArtistProfileFragment.newInstance(item)).commit();
        }
    }
}
