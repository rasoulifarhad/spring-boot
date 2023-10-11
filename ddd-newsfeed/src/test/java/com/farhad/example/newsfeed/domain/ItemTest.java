package com.farhad.example.newsfeed.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setup() {
        item = new Item();
        item.setTitle("Women's World Cup 2019");

        item.setLink("https://trends.google.com/trends/trendingsearches/daily?geo=US#Women's%20World%20Cup%202019");
        item.setPicture("https://t2.gstatic.com/images?q=tbn:ANd9GcTW4UzPHNC9qjHRxBr6kCUEns71l8XK6HYcmLpJbhlfZWUbeBQPiia1GDzN3Ehl7nfD-HPbgnG_");    

        Tag tag = new Tag();
        tag.setName("Word cup");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        item.setDescription(tags);

        NewsItem newsItem = new NewsItem();

        Source source = new Source();
        source.setName("USA TODAY");

        newsItem.setSource(source);
        newsItem.setTitle("&lt;b&gt;2019 Women&amp;#39;s World Cup&lt;/b&gt; scores, highlights: Canada squeaks by, Japan underwhelms, Argentina gets historic point");

        List<NewsItem> items = new ArrayList<>();
        items.add(newsItem);
        item.setItems(items);
    }

    @Test
    public void buildNewsItemTest()  {

        assertEquals(1, item.getItems().size());
        assertEquals(1, item.getDescription().size());
    }

    @Test
    public void convertStringToLongTest() {
        String approxTraffic = "900,000+";
        item.setApproxTraffic(approxTraffic);
        item.setApproxTrafficAsNumber(item.convertStringToLong(approxTraffic));
        assertEquals(900000, item.getApproxTrafficAsNumber().longValue());
    }

    @Test
    public void convertStringToDateTest() {
        String pubDateAsString = "Mon, 1 Jun 2020 20:40:00 +0330";
        item.setPubDateAsString(pubDateAsString);
        try {
            item.setPubDate(item.convertStringToDate(pubDateAsString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ZonedDateTime zonedDateTime = 
            ZonedDateTime.of(
                    2020, 
                    6, 
                    1, 
                    20, 
                    40, 
                    0, 
                    0, 
                    ZoneOffset.ofHoursMinutes(3, 30));
        assertEquals(item.getPubDate(), zonedDateTime.toInstant());
    }

}
