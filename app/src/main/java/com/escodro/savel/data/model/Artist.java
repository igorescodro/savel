package com.escodro.savel.data.model;

/**
 * Object containing the consolidated information about the artist.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class Artist {

    private String mName;

    private String mBio;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }
}
