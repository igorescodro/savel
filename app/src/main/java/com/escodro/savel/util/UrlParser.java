package com.escodro.savel.util;

import android.text.TextUtils;

import com.escodro.savel.data.model.musicbrainz.MusicBrainzRelation;

import java.util.List;

/**
 * Utility class to parse the URL to get third-party ids from {@link MusicBrainzRelation}.
 * <p/>
 * Created by Igor Escodro on 19/04/17.
 */
public class UrlParser {

    /**
     * Get the Discogs id from {@link MusicBrainzRelation}.
     *
     * @param relationList list of MusicBrainz relation
     * @return Discogs id
     */
    public static String getDiscogsId(List<MusicBrainzRelation> relationList) {
        String result = null;
        for (MusicBrainzRelation relation : relationList) {
            if (TextUtils.equals(relation.getType(), "discogs")) {
                result = getDiscogsIdFromUrl(relation.getUrl().getResource());
                break;
            }
        }
        return result;
    }

    /**
     * Parse the url to get the Discogs id from artist url.
     *
     * @param url Discogs artist url
     * @return Discogs id
     */
    private static String getDiscogsIdFromUrl(String url) {
        return url.replaceFirst(".*/([^/?]+).*", "$1");
    }
}
