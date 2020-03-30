package org.caresptogo.covid_19tg.model;

import java.io.Serializable;

public class Youtube implements Serializable {

    String title;
    String link;

    public Youtube() {
    }

    public Youtube(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
