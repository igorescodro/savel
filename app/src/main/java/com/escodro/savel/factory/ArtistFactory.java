package com.escodro.savel.factory;

import com.escodro.savel.SavelApp;
import com.escodro.savel.model.Artist;
import com.escodro.savel.network.echonest.EchoNestAPI;
import com.escodro.savel.network.echonest.model.EchoNestResponse;
import com.escodro.savel.network.musicbrainz.MusicBrainzAPI;
import com.escodro.savel.network.spotify.SpotifyAPI;
import com.escodro.savel.requests.RequestManager;
import com.escodro.savel.requests.apis.LastFmRequest;
import com.escodro.savel.requests.apis.MusicBrainzRequest;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Class responsible to create a {@link Artist} object. Because of the creation of the object is not
 * synchronous due dependence of the server response, it notifies the {@link
 * RequestManager.OnRequestFinishListener} with the object created when everything is finished.
 * <p/>
 * Created by IgorEscodro on 03/07/15.
 */
public class ArtistFactory {

    /**
     * Constant do represent the {@link SpotifyAPI} prefix to be used in the {@link EchoNestAPI}
     * query.
     */
    private static final String SPOTIFY_QUERY_PREFIX = "spotify:artist:";

    /**
     * Field to represent the {@link SpotifyAPI} id.
     */
    private String mSpotifyId;

    /**
     * {@link com.escodro.savel.requests.RequestManager.OnRequestFinishListener} reference.
     */
    private RequestManager.OnRequestFinishListener mListener;

    /**
     * Request the creation of a {@link Artist} object. When it is created, the listener will be
     * notified.
     *
     * @param spotifyId {@link SpotifyAPI} unique id
     * @param listener  listener to be notified
     */
    public void createDataBySpotifyId(String spotifyId,
                                      RequestManager.OnRequestFinishListener listener) {
        mSpotifyId = spotifyId;
        mListener = listener;
        getMusicBrainzId();
    }

    /**
     * Method to get the {@link MusicBrainzAPI} id from the {@link SpotifyAPI} item using the {@link
     * EchoNestAPI}.
     */
    private void getMusicBrainzId() {
        SavelApp.getEchoNestAPI().searchArtistBySpotifyId(SPOTIFY_QUERY_PREFIX + mSpotifyId,
                new Callback<EchoNestResponse>() {
                    @Override
                    public void success(EchoNestResponse echoNestResponse, Response response) {
                        final String mbid = echoNestResponse.getResponse().getArtist()
                                .getMusicBrainzId();
                        requestData(mbid);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println("FALHA!");
                    }
                });
    }

    /**
     * Method to request all the data using the {@link RequestManager}.
     *
     * @param mbid {@link MusicBrainzAPI} id.
     */
    private void requestData(String mbid) {
        final RequestManager manager = SavelApp.getRequestManager();
        manager.add(new LastFmRequest(mbid));
        manager.add(new MusicBrainzRequest(mbid));
        manager.execute(mListener);
    }
}
