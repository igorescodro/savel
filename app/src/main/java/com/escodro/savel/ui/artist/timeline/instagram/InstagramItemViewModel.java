package com.escodro.savel.ui.artist.timeline.instagram;

import android.text.TextUtils;
import android.view.View;

import com.escodro.savel.data.model.SavelInstagram;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.ui.base.TimelineEntryViewModel;

import javax.inject.Inject;

/**
 * ViewModel to load information about a {@link InstagramItem} in the view.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class InstagramItemViewModel extends TimelineEntryViewModel {

    private static final String TYPE_VIDEO = "video";

    private SavelInstagram mInstagramItem;

    @Inject
    public InstagramItemViewModel() {
    }

    public void setInstagramItem(SavelInstagram instagramItem) {
        mInstagramItem = instagramItem;
    }

    public String getImage() {
        return mInstagramItem.getImageUrl();
    }

    public String getUsername() {
        return mInstagramItem.getUsername();
    }

    public String getProfilePicture() {
        return mInstagramItem.getProfilePicture();
    }

    public int getVideoIconVisibility() {
        int visibility = View.INVISIBLE;
        if (TextUtils.equals(mInstagramItem.getType(), TYPE_VIDEO)) {
            visibility = View.VISIBLE;
        }
        return visibility;
    }

    @Override
    protected String getEntryUrl() {
        return mInstagramItem.getLink();
    }
}
