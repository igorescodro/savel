
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Description entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterDescription {

    @SerializedName("urls")
    private List<Object> urls = null;
}
