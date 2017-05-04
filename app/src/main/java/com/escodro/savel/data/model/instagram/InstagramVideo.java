
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Video entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramVideo {

    @SerializedName("standard_resolution")
    private InstagramResolution standardResolution;

    @SerializedName("low_bandwidth")
    private InstagramResolution lowBandwidth;

    @SerializedName("low_resolution")
    private InstagramResolution lowResolution;

    public InstagramResolution getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(InstagramResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    public InstagramResolution getLowBandwidth() {
        return lowBandwidth;
    }

    public void setLowBandwidth(InstagramResolution lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }

    public InstagramResolution getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(InstagramResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

}
