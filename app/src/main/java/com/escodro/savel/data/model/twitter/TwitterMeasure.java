
package com.escodro.savel.data.model.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Object to represent the Measure entity in
 * {@link com.escodro.savel.data.remote.service.TwitterService}.
 */
public class TwitterMeasure {

    @SerializedName("w")
    private Integer w;

    @SerializedName("h")
    private Integer h;

    @SerializedName("resize")
    private String resize;

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public String getResize() {
        return resize;
    }

    public void setResize(String resize) {
        this.resize = resize;
    }

}
