package com.mjc.school.repository.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsRepository {

    private List<News> newsList = new ArrayList<>();

    public News create(News news) {
        newsList.add(news);
        return news;
    }

    public List<News> readAll() {
        return newsList;
    }

    public Optional<News> readBy(Long id) {
        return newsList.stream().filter(news -> news.getId().equals(id)).findFirst();
    }

    public News update(News news) {
        newsList.removeIf(news1 -> news1.getId().equals(news.getId()));
        newsList.add(news);
        return news;
    }

    public Boolean delete(News news) {
        return newsList.removeIf(news1 -> news1.getId().equals(news.getId()));
    }
}