package com.escodro.savel.ui.artist.timeline.entry;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.ui.artist.timeline.instagram.InstagramEntry;
import com.escodro.savel.ui.artist.timeline.twitter.TwitterEntry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Adapter to convert the {@link SavelArtist} attributes in a {@link List} of {@link TimelineEntryType}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineEntryAdapter {

    @Inject
    Provider<TwitterEntry> mTwitterProvider;

    @Inject
    Provider<InstagramEntry> mInstagramProvider;

    @Inject
    TimelineEntryComparator mComparator;

    @Inject
    public TimelineEntryAdapter() {
    }

    /**
     * Extract a {@link List} of {@link TimelineEntryType} from an {@link SavelArtist}.
     *
     * @param artist artist with timeline attributes
     *
     * @return list of timeline entries
     */
    public List<TimelineEntryType> extractTimeline(@NonNull SavelArtist artist) {
        final List<TimelineEntryType> timeline = new ArrayList<>();
        timeline.addAll(getTwitterEntries(artist.getTweetList()));
        timeline.addAll(getInstagramEntries(artist.getInstagramTimeline()));

        timeline.sort(mComparator);

        return timeline;
    }

    private List<TimelineEntryType> getTwitterEntries(List<SavelTweet> tweets) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        if (tweets != null) {
            for (SavelTweet tweet : tweets) {
                final TwitterEntry entry = mTwitterProvider.get();
                entry.setTweet(tweet);
                timeline.add(entry);
            }
        }

        return timeline;
    }

    private List<TimelineEntryType> getInstagramEntries(List<InstagramItem> items) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        if (items != null) {
            for (InstagramItem item : items) {
                final InstagramEntry entry = mInstagramProvider.get();
                entry.setInstagramItem(item);
                timeline.add(entry);
            }
        }

        return timeline;
    }
}
