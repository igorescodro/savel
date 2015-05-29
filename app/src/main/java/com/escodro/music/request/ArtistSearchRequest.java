package com.escodro.music.request;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestException;

import java.util.List;

/**
 * Create a request to {@link com.echonest.api.v4.EchoNestAPI} to get artist based on its name.
 * <p/>
 * Created by IgorEscodro on 24/05/15.
 */
public class ArtistSearchRequest extends MusicRequest<String, Void, List<Artist>> {

    /**
     * Create a new instance of {@link ArtistSearchRequest}.
     *
     * @param listener new instance of {@link ArtistSearchRequest}
     */
    public ArtistSearchRequest(MusicRequestListener listener) {
        super(listener);
    }

    /**
     * Create the request to search artist by name.
     *
     * @param string artist name
     *
     * @return {@link List} of {@link Artist}
     */
    @Override
    protected List<Artist> doInBackground(String... string) {
        List<Artist> artistList = null;
        try {
            artistList = getAPI().searchArtists(string[0], 50);
        } catch (EchoNestException e) {
            e.printStackTrace();
        }
        return artistList;
    }
}
