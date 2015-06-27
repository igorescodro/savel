package com.escodro.savel.network.lastfm.model;

import com.escodro.savel.network.lastfm.LastFmAPI;

/**
 * Object to represent an {@link LastFmAPI} {@link Bio}.
 */
public class Bio {

    /**
     * {@link Bio} content.
     */
    private String content;

    /**
     * {@link Bio} summary.
     */
    private String summary;

    /**
     * {@link Bio} formation list.
     */
    private FormationList formationlist;

    /**
     * {@link Bio} year formed.
     */
    private String yearformed;

    /**
     * {@link Bio} links.
     */
    private Links links;

    /**
     * {@link Bio} published.
     */
    private String published;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public FormationList getFormationlist() {
        return formationlist;
    }

    public void setFormationlist(FormationList formationlist) {
        this.formationlist = formationlist;
    }

    public String getYearformed() {
        return yearformed;
    }

    public void setYearformed(String yearformed) {
        this.yearformed = yearformed;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
