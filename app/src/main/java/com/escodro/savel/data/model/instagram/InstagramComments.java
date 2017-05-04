
package com.escodro.savel.data.model.instagram;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Comments entity in
 * {@link com.escodro.savel.data.remote.service.InstagramService}.
 */
public class InstagramComments {

    @SerializedName("data")
    private List<InstagramData> data = null;

    @SerializedName("count")
    private Integer count;

    public List<InstagramData> getData() {
        return data;
    }

    public void setData(List<InstagramData> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
