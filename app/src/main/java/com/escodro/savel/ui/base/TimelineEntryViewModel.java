package com.escodro.savel.ui.base;

import android.view.View;

import com.escodro.savel.ui.common.CustomTabsHandler;

import javax.inject.Inject;

/**
 * Abstract Timeline Entry View Model to open the item in Chrome when clicked.<br>
 * <b>The method {@link TimelineEntryViewModel#onItemClick()} must be called in the xml in the
 * most external layout.</b>
 * <p/>
 * Created by Igor Escodro on 09/05/17.
 */
public abstract class TimelineEntryViewModel {

    @Inject
    CustomTabsHandler mCustomTabsHandler;

    /**
     * Method to provide the URL related to the row entry.
     *
     * @return entry url
     */
    protected abstract String getEntryUrl();

    /**
     * Method to be called in the xml via Data Binding to open the item in Chrome.
     *
     * @return item click listener
     */
    public View.OnClickListener onItemClick() {
        return view -> mCustomTabsHandler.launchUrl(getEntryUrl());
    }
}
