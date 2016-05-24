package com.epam.ali.testapp.model;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class News extends BaseEntity {
    private String title;
    private DateTime date;
    private String brief;
    private String content;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/YYYY");
        return date.toString(formatter);
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
