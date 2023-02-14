package com.mjc.school.repository.implementation;

import com.mjc.school.repository.implementation.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsRepository {

    private List<News> newsList = new ArrayList<>();

    public News createNews(News news) {
        newsList.add(news);
        return news;
    }

    public List<News> getAllNews() {
        return newsList;
    }

    public Optional<News> getNewsById(Long id) {
        return newsList.stream().filter(news -> news.getId().equals(id)).findFirst();
    }

    public News updateNews(News news) {
        newsList.removeIf(news1 -> news1.getId().equals(news.getId()));
        newsList.add(news);
        return news;
    }

    public boolean deleteNews(News news) {
        return newsList.removeIf(news1 -> news1.getId().equals(news.getId()));
    }
}