package com.mjc.school.repository.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsRepository {

    private List<News> newsList = new ArrayList<>();

    public ProjectModel create(News news) {
        newsList.add(news);
        return new ProjectModel();
    }

    public List<News> readAll() {
        return newsList;
    }

    public Optional<News> readBy(Long id) {
        return newsList.stream().filter(news -> news.getId().equals(id)).findFirst();
    }

    public ProjectModel update(News news) {
        newsList.removeIf(news1 -> news1.getId().equals(news.getId()));
        newsList.add(news);
        return new ProjectModel();
    }

    public Boolean delete(Long id) {
        return newsList.removeIf(news1 -> news1.getId().equals(id));
    }
}