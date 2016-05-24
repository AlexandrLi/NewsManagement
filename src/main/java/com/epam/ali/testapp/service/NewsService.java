package com.epam.ali.testapp.service;

import com.epam.ali.testapp.model.News;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class NewsService {

    public List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();
        News newsMessage = new News();
        newsMessage.setId(1);
        newsMessage.setTitle("Test news");
        newsMessage.setDate(DateTime.now());
        newsMessage.setBrief("Test news brief");
        newsMessage.setContent("Test news content");
        newsList.add(newsMessage);
        newsList.add(newsMessage);
        newsList.add(newsMessage);
        newsList.add(newsMessage);
        return newsList;
    }
}
