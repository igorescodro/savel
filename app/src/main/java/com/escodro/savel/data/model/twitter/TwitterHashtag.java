
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Hashtag entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterHashtag {

    @SerializedName("text")
    private String text;

    @SerializedName("indices")
    private List<Integer> indices = null;
}
