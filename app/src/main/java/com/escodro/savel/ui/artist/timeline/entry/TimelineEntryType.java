package com.escodro.savel.ui.artist.timeline.entry;

import android.support.annotation.IntDef;

import com.escodro.savel.util.viewholder.BindingHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Interface to represent different types of Timeline entries.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public interface TimelineEntryType {

    /**
     * Annotation to represent the available entry types in the timeline.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TWITTER_ROW_TYPE, INSTAGRAM_ROW_TYPE, FACEBOOK_ROW_TYPE})
    public @interface EntryType {
    }

    /**
     * Value to represent that the row is from Twitter.
     */
    int TWITTER_ROW_TYPE = 0;

    /**
     * Value to represent that the row is from Instagram.
     */
    int INSTAGRAM_ROW_TYPE = 1;

    /**
     * Value to represent that the row is from Facebook.
     */
    int FACEBOOK_ROW_TYPE = 2;

    /**
     * Return the {@link EntryType} related to the row.
     *
     * @return entry type
     */
    @EntryType
    int getItemViewType();

    /**
     * Method to update the contents of {@link BindingHolder#itemView}} to  reflect the
     * item at the adapter position. As the application structured is based on MVVM and Data
     * Binding this method should set the respective ViewModel in the
     * {@link BindingHolder#binding} and update the data with the current position.
     *
     * @param holder the BindingHolder should be updated to represent the contents of the item
     */
    void onBindViewHolder(BindingHolder holder);

    /**
     * Method to provide the entry creation time in milliseconds.
     *
     * @return time in milliseconds
     */
    long getEntryTimeInMillis();
}
