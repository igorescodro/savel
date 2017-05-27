package com.escodro.savel.util.adapter;

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
     * Relation type indicating the resource is from a streaming music service.
     */
    private static final String STREAMING_MUSIC = "streaming music";

    /**
     * Host indicating the resource is from Twitter.
     */
    private static final String TWITTER_HOST = "twitter.com";

    /**
     * Host indicating the resource is from Spotify.
     */
    private static final String SPOTIFY_HOST = "open.spotify.com";

    /**
     * Host indicating the resource is from Instagram.
     */
    private static final String INSTAGRAM_HOST = "instagram.com";

    /**
     * Host indicating the resource is from Facebook.
     */
    private static final String FACEBOOK_HOST = "facebook.com";

    private List<MusicBrainzRelation> mRelationList;

    private String mDiscogsId;

    private String mTwitterId;

    private String mSpotifyId;

    private String mInstagramId;

    private String mFacebookId;

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
        if (mRelationList == null) return;

        for (MusicBrainzRelation relation : mRelationList) {
            final String url = relation.getUrl();
            final String type = relation.getType();

            if (type == null) return;

            switch (type) {
                case DISCOGS:
                    mDiscogsId = extractIdFromLastPath(url);
                    break;
                case SOCIAL_NETWORK:
                    processSocialNetwork(url);
                    break;
                case STREAMING_MUSIC:
                    processStreamingService(url);
                    break;
                default:
                    //Do nothing.
            }
        }
    }

    /**
     * Process the {@link RelationParser#SOCIAL_NETWORK} type based on its URL host once there is
     * no information from the server indicating the source.
     *
     * @param urlString url to be processed
     */
    private void processSocialNetwork(String urlString) {
        final String host = getHostWithoutPrefix(urlString);
        if (host == null) return;

        switch (host) {
            case TWITTER_HOST:
                mTwitterId = extractIdFromLastPath(urlString);
                break;
            case INSTAGRAM_HOST:
                mInstagramId = extractIdFromLastPath(urlString);
                break;
            case FACEBOOK_HOST:
                mFacebookId = extractIdFromLastPath(urlString);
                break;
            default:
                //Do nothing.
        }
    }

    /**
     * Process the {@link RelationParser#STREAMING_MUSIC} type based on its URL host once there is
     * no information from the server indicating the source.
     *
     * @param urlString url to be processed
     */
    private void processStreamingService(String urlString) {
        final URL url = getHost(urlString);
        if (url == null) return;

        switch (url.getHost()) {
            case SPOTIFY_HOST:
                mSpotifyId = extractIdFromLastPath(urlString);
                break;
            default:
                //Do nothing.
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
            Timber.w("Url from social network malformed. Skipping invalid URL: %s", urlString);
            return null;
        }
        return url;
    }

    /**
     * Extract the last segment from a url path.<br>
     * E.g. url <code>http://github.com/igorescodro</code> will return <code>igorescodro</code>
     *
     * @param url url to be parsed
     *
     * @return last path segment from url
     */
    @Nullable
    private String extractIdFromLastPath(String url) {
        return url.replaceFirst(".*/([^/?]+).*", "$1");
    }

    /**
     * Get the host from a url, ignoring the <i>www.</i> prefix on it.
     * E.g. url <code>http://www.github.com/igorescodro</code> will return <code>github.com</code>
     *
     * @param stringUrl url to be parsed
     *
     * @return formatted host from url
     */
    @Nullable
    private String getHostWithoutPrefix(@NonNull String stringUrl) {
        String result = null;
        final URL url = getHost(stringUrl);
        if (url != null) {
            result = url.getHost().replaceFirst("^(http://www\\.|http://|www\\.)", "");
        }
        return result;
    }

    @Nullable
    public String getDiscogsId() {
        return mDiscogsId;
    }

    @Nullable
    public String getTwitterId() {
        return mTwitterId;
    }

    @Nullable
    public String getSpotifyId() {
        return mSpotifyId;
    }

    @Nullable
    public String getInstagramId() {
        return mInstagramId;
    }

    public String getFacebookId() {
        return mFacebookId;
    }
}
