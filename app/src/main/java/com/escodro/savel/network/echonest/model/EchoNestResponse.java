package com.escodro.savel.network.echonest.model;

import com.escodro.savel.network.echonest.EchoNestAPI;

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
