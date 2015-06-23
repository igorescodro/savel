package com.escodro.savel.interfaces;

import android.view.View;

/**
 * Interface to notify when an specific item in position was clicked.
 * <p/>
 * Created by IgorEscodro on 14/06/15.
 */
public interface OnItemClickListener {

    /**
     * Notify when the view is clicked with the position.
     *
     * @param view     {@link View} clicked
     * @param position item position
     */
    void onItemClick(View view, int position);
}
