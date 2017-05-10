
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the URL List entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterUrlList {

    @SerializedName("urls")
    private List<TwitterProfileUrl> urls = null;
}
