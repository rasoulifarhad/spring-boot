package com.farhad.example.newsfeed.domain;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;

@Data
public class Item {
 
    private String title;
    private List<Tag> description;
    private String link;
    private String picture;
    private Instant pubDate;
    private String pubDateAsString;

    private String approxTraffic;
    private Long approxTrafficAsNumber;    

    private List<NewsItem> items;
    private Country country;

    public Instant convertStringToDate(String pubDateAsString) throws ParseException {
        DateTimeFormatter formatter = 
            DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z"); 
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(pubDateAsString, formatter);
        return zonedDateTime.toInstant();
    }

    public Long convertStringToLong(String approxTrafficAsNumber) {
        return new Long(
            approxTrafficAsNumber
                .replaceAll(",", "")
                .replace("+", ""));
    }

}
