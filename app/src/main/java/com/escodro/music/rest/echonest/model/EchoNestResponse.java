package com.escodro.music.rest.echonest.model;

import com.escodro.music.rest.echonest.EchoNestAPI;

/**
 * Object to represent an {@link EchoNestAPI} {@link
 * EchoNestResponse}.
 */
public class EchoNestResponse {

    /**
     * {@link EchoNestResponse} response.
     */
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
