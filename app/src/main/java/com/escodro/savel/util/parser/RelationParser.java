package com.escodro.savel.util.parser;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzRelation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Helper to parse a {@link List} of {@link MusicBrainzRelation} and retrieve the id from each
 * resource. This id will be used to get profile from third-party APIs.
 * <p>
 * Created by Igor Escodro on 26/04/17.
 */
public class RelationParser {

    /**
     * Relation type indicating the resource is from Discogs.
     */
    private static final String DISCOGS = "discogs";

    /**
     * Relation type indicating the resource is from a social network.
     */
    private static final String SOCIAL_NETWORK = "social network";

    /**
     * Host indicating the resource is from Twitter.
     */
    private static final String TWITTER_HOST = "twitter.com";

    private List<MusicBrainzRelation> mRelationList;

    private String mDiscogsId;

    private String mTwitterId;

    @Inject
    public RelationParser() {
    }

    /**
     * Set the {@link List} of {@link MusicBrainzRelation} to be processed, parsing the ids from
     * the resources.
     *
     * @param relationList list of MusicBrainz Relation
     */
    public void setRelationList(@NonNull List<MusicBrainzRelation> relationList) {
        mRelationList = relationList;
        processList();
    }

    /**
     * Process the list to retrieve the ids from various resources.
     */
    private void processList() {
        for (MusicBrainzRelation relation : mRelationList) {
            final String url = relation.getUrl().getResource();
            switch (relation.getType()) {
                case DISCOGS:
                    mDiscogsId = extractIdFromLastPath(url);
                    break;
                case SOCIAL_NETWORK:
                    processSocialNetwork(url);
                    break;
            }
        }
    }

    /**
     * Process the {@link RelationParser#SOCIAL_NETWORK} type based on its URL host once there is
     * no information from the server indication the source.
     *
     * @param urlString url to be processed
     */
    private void processSocialNetwork(String urlString) {
        final URL url = getHost(urlString);
        if (url == null) return;

        switch (url.getHost()) {
            case TWITTER_HOST:
                mTwitterId = extractIdFromLastPath(urlString);
                break;
        }
    }

    /**
     * Get the Host from URL.
     *
     * @param urlString url in string format
     *
     * @return host from url
     */
    @Nullable
    private URL getHost(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            Timber.w("Url from social network malformed. Skipping invalid URL: " + urlString);
            return null;
        }
        return url;
    }

    private String extractIdFromLastPath(String url) {
        return url.replaceFirst(".*/([^/?]+).*", "$1");
    }

    @Nullable
    public String getDiscogsId() {
        return mDiscogsId;
    }

    @Nullable
    public String getTwitterId() {
        return mTwitterId;
    }
}
