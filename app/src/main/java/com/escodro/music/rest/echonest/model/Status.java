package com.escodro.music.rest.echonest.model;

/**
 * Object to represent an {@link com.escodro.music.rest.echonest.EchoNestAPI} {@link Artist}.
 */
public class Status {

    /**
     * {@link Status} message.
     */
    private String message;

    /**
     * {@link Status} code.
     */
    private String code;

    /**
     * {@link Status} version.
     */
    private String version;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
