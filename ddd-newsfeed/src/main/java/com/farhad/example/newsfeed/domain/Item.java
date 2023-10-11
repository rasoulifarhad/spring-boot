package com.farhad.example.newsfeed.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Item {
 
    private String title;
    private List<Tag> description;
    private String link;
    private String picture;
    private Date pubDate;
    private String pubDateAsString;

    private String approxTraffic;
    private Long approxTrafficAsNumber;    

    private List<NewsItem> items;
    private Country country;

    public Date convertStringToDate(String pubDateAsString) throws ParseException {
        SimpleDateFormat parder = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z"); // Wed, 21 Dec 2023 13:00:00 +0200
        return parder.parse(pubDateAsString);
    }

    public Long convertStringToLong(String approxTrafficAsNumber) throws ParseException {
        return new Long(
            approxTrafficAsNumber
                .replaceAll(",", "")
                .replaceAll("+", ""));
    }

}
