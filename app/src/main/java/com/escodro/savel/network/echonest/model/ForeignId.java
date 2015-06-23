package com.escodro.savel.network.echonest.model;

/**
 * Object to represent an {@link com.escodro.savel.network.echonest.EchoNestAPI} {@link ForeignId}.
 */
public class ForeignId {

    /**
     * {@link ForeignId} id.
     */
    private String foreign_id;

    /**
     * {@link ForeignId} catalog.
     */
    private String catalog;

    public String getForeign_id() {
        return foreign_id;
    }

    public void setForeign_id(String foreign_id) {
        this.foreign_id = foreign_id;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
