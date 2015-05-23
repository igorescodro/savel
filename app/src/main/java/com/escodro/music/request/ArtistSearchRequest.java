package com.escodro.music.request;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestException;

import java.util.List;

/**
 * Created by IgorEscodro on 24/05/15.
 */
public class ArtistSearchRequest extends MusicRequest<String, Void, List<Artist>> {

    public ArtistSearchRequest(MusicRequestListener listener) {
        super(listener);
    }

    @Override
    protected List<Artist> doInBackground(String... string) {
        List<Artist> artistList = null;
        try {
            artistList = getAPI().searchArtists(string[0]);
        } catch (EchoNestException e) {
            e.printStackTrace();
        }
        return artistList;
    }
}
