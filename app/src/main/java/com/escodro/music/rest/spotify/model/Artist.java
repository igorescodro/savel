package com.escodro.music.rest.spotify.model;

import com.escodro.music.rest.spotify.SpotifyAPI;

import java.util.List;

/**
 * Object to represent an {@link SpotifyAPI} {@link Artist}.
 */
public class Artist {

    /**
     * {@link Artist} total.
     */
    private String total;

    /**
     * {@link Artist} limit.
     */
    private String limit;

    /**
     * {@link Artist} previous.
     */
    private String previous;

    /**
     * {@link Artist} items.
     */
    private List<Item> items;

    /**
     * {@link Artist} next.
     */
    private String next;

    /**
     * {@link Artist} offset.
     */
    private String offset;

    /**
     * {@link Artist} href.
     */
    private String href;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
