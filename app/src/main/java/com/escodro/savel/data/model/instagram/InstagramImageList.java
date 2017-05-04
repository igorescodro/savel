
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Image List entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramImageList {

    @SerializedName("thumbnail")
    private InstagramResolution thumbnail;

    @SerializedName("low_resolution")
    private InstagramResolution lowResolution;

    @SerializedName("standard_resolution")
    private InstagramResolution standardResolution;

    public InstagramResolution getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(InstagramResolution thumbnail) {
        this.thumbnail = thumbnail;
    }

    public InstagramResolution getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(InstagramResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    public InstagramResolution getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(InstagramResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

}
