package com.escodro.savel.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.R;

/**
 * Main {@link AppCompatActivity} of Music Project application.
 * <p/>
 * Created by IgorEscodro on 22/05/15.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArtistSearchActivity.startActivity();
    }
}
