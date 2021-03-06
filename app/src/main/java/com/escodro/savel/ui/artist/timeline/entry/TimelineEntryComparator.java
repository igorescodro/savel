package com.escodro.savel.ui.artist.timeline.entry;

import java.io.Serializable;
import java.util.Comparator;

import javax.inject.Inject;

/**
 * Custom comparator to sort descending the {@link TimelineEntryType} based on the time of the
 * entry.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class TimelineEntryComparator implements Comparator<TimelineEntryType>, Serializable {

    private static final long serialVersionUID = 3L;

    /**
     * Default injectable constructor.
     */
    @Inject
    public TimelineEntryComparator() {
    }

    @Override
    public int compare(TimelineEntryType t0, TimelineEntryType t1) {
        return Long.compare(t1.getEntryTimeInMillis(), t0.getEntryTimeInMillis());
    }
}
