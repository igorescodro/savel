package com.escodro.savel.ui.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.ui.artist.ArtistActivity;

import javax.inject.Inject;

/**
 * ViewModel responsible to provide {@link SavelArtist} information to
 * {@link com.escodro.savel.databinding.ItemArtistSearchBinding}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */

public class SearchItemViewModel {

    private SavelArtist mArtist;

    @Inject
    Context mContext;

    @Inject
    public SearchItemViewModel() {
    }

    public void setArtist(@NonNull SavelArtist artist) {
        mArtist = artist;
    }

    @Nullable
    public String getName() {
        String name = null;
        if (mArtist != null) {
            name = mArtist.getName();
        }
        return name;
    }

    public View.OnClickListener onItemClick() {
        return view -> {
            if (mArtist == null) {
                return;
            }
            ArtistActivity.startActivity(mContext, mArtist.getId());
        };
    }
}
