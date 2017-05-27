package com.escodro.savel.ui.search;

import android.text.TextUtils;

import com.escodro.savel.data.model.SavelArtist;

import java.io.Serializable;
import java.util.Comparator;

import javax.inject.Inject;

/**
 * Custom comparator to send all the {@link SavelArtist}s without {@link SavelArtist#getArea()}
 * to the bottom of the list. This is needed once
 * {@link com.escodro.savel.data.remote.service.MusicBrainzService}
 * does not have a nice implementation of popularity and less famous artists can appear on top.
 * <p/>
 * Created by IgorEscodro on 24/05/17.
 */
public class SearchComparator implements Comparator<SavelArtist>, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    public SearchComparator() {
    }

    @Override
    public int compare(SavelArtist t0, SavelArtist t1) {
        if (TextUtils.equals(t0.getArea(), t1.getArea())) {
            return 0;
        }
        if (t0.getArea() == null) {
            return 1;
        }
        if (t1.getArea() == null) {
            return -1;
        }
        return 0;
    }
}
