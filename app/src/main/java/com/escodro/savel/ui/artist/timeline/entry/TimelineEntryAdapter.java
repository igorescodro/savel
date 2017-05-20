package com.escodro.savel.ui.artist.timeline.entry;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.data.model.SavelFacebook;
import com.escodro.savel.data.model.SavelInstagram;
import com.escodro.savel.data.model.SavelTweet;
import com.escodro.savel.ui.artist.timeline.facebook.FacebookEntry;
import com.escodro.savel.ui.artist.timeline.instagram.InstagramEntry;
import com.escodro.savel.ui.artist.timeline.twitter.TwitterEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Adapter to convert the {@link SavelArtist} attributes in a {@link List} of {@link
 * TimelineEntryType}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineEntryAdapter {

    @Inject
    Provider<TwitterEntry> mTwitterProvider;

    @Inject
    Provider<InstagramEntry> mInstagramProvider;

    @Inject
    Provider<FacebookEntry> mFacebookProvider;

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
        timeline.addAll(getFacebookEntries(artist.getFacebookTimeline()));

        Collections.sort(timeline, mComparator);

        return timeline;
    }

    @NonNull
    private List<TimelineEntryType> getTwitterEntries(@NonNull List<SavelTweet> tweets) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        for (SavelTweet tweet : tweets) {
            final TwitterEntry entry = mTwitterProvider.get();
            entry.setTweet(tweet);
            timeline.add(entry);
        }

        return timeline;
    }

    @NonNull
    private List<TimelineEntryType> getInstagramEntries(@NonNull List<SavelInstagram> items) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        for (SavelInstagram item : items) {
            final InstagramEntry entry = mInstagramProvider.get();
            entry.setInstagramItem(item);
            timeline.add(entry);
        }

        return timeline;
    }

    @NonNull
    private List<TimelineEntryType> getFacebookEntries(@NonNull List<SavelFacebook> items) {
        final List<TimelineEntryType> timeline = new ArrayList<>();

        for (SavelFacebook item : items) {
            final FacebookEntry entry = mFacebookProvider.get();
            entry.setFacebookItem(item);
            timeline.add(entry);
        }

        return timeline;
    }
}
