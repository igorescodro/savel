package com.escodro.music.rest.echonest;

import com.escodro.music.rest.echonest.model.Artist;
import com.escodro.music.rest.echonest.model.EchoNestResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface containing the methods to create requests to EchoNest.
 *
 * @see <a href="http://developer.echonest.com/docs/v4">Echo Nest API Overview</a>
 * <p/>
 * Created by IgorEscodro on 29/05/15.
 */
public interface EchoNestAPI {

    /**
     * {@link EchoNestAPI} request to search artists.
     *
     * @param name     {@link Artist} name
     * @param result   maximum number of results
     * @param fuzzy    search for similar names (similar to LIKE in SQL)
     * @param sort     sort criteria
     * @param callback {@link Callback} to be implemented to handle request response
     *
     * @see <a href="http://developer.echonest.com/docs/v4/artist.html#search">Echo Nest API
     * Overview - Search</a>
     */
    @GET(EchoNestClient.ARTIST_SEARCH_URL)
    void searchArtistByName(@Query("name") String name, @Query("results") int result, @Query
            ("fuzzy_match") boolean fuzzy, @Query("sort") String sort,
                            Callback<EchoNestResponse> callback);
}
