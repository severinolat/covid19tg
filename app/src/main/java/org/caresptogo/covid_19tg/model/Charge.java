package org.caresptogo.covid_19tg.model;


import androidx.annotation.Nullable;

import java.io.Serializable;

public class Charge implements Serializable {

    String title;
    String content;
    String date;
    String images;


    public Charge(){

    }

    public Charge(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Charge(String title, String content, String date, String images) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
