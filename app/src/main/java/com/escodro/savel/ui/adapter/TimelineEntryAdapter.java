package com.escodro.savel.ui.adapter;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.Artist;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.data.model.twitter.TwitterTweet;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Adapter to convert the {@link Artist} attributes in a {@link List} of {@link TimelineEntryType}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineEntryAdapter {

    @Inject
    Provider<TwitterEntry> mTwitterProvider;

    @Inject
    Provider<InstagramEntry> mInstagramProvider;

    @Inject
    public TimelineEntryAdapter() {
    }

    /**
     * Extract a {@link List} of {@link TimelineEntryType} from an {@link Artist}.
     *
     * @param artist artist with timeline attributes
     *
     * @return list of timeline entries
     */
    public List<TimelineEntryType> extractTimeline(@NonNull Artist artist) {
        final List<TimelineEntryType> timeline = new ArrayList<>();
        timeline.addAll(getTwitterEntries(artist.getTweetList()));
        timeline.addAll(getInstagramEntries(artist.getInstagramTimeline()));

        return timeline;
    }

    private List<TimelineEntryType> getTwitterEntries(List<TwitterTweet> tweets) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        if (tweets != null) {
            for (TwitterTweet tweet : tweets) {
                final TwitterEntry entry = mTwitterProvider.get();
                entry.setTwitterTweet(tweet);
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
