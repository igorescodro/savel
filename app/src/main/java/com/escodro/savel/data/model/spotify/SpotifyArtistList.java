
package com.escodro.savel.data.model.spotify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object to represent the Artist List entity in
 * {@link com.escodro.savel.data.remote.service.SpotifyService}.
 */
public class SpotifyArtistList {

    @SerializedName("href")
    private String href;

    @SerializedName("items")
    private List<SpotifyArtist> items = null;

    @SerializedName("limit")
    private Integer limit;

    @SerializedName("next")
    private String next;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("previous")
    private Object previous;

    @SerializedName("total")
    private Integer total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<SpotifyArtist> getItems() {
        return items;
    }

    public void setItems(List<SpotifyArtist> items) {
        this.items = items;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
