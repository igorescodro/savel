package com.escodro.savel.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.escodro.savel.data.model.Artist;
import com.escodro.savel.ui.activity.ArtistActivity;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link Artist} information to
 * {@link com.escodro.savel.databinding.ItemArtistSearchBinding}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */

public class SearchItemViewModel {

    private Artist mArtist;

    @Inject
    Context mContext;

    @Inject
    public SearchItemViewModel() {
    }

    public void setArtist(@NonNull Artist artist) {
        mArtist = artist;
    }

    public String getName() {
        return mArtist.getName();
    }

    public View.OnClickListener onItemClick() {
        return view -> {
            final Intent intent = new Intent(mContext, ArtistActivity.class);
            intent.putExtra(ArtistActivity.EXTRA_ARTIST_ID, mArtist.getId());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        };
    }
}
