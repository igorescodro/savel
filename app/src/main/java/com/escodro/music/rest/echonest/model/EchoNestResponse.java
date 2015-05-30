package com.escodro.music.rest.echonest.model;

/**
 * Object to represent an {@link com.escodro.music.rest.echonest.EchoNestAPI} {@link
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
