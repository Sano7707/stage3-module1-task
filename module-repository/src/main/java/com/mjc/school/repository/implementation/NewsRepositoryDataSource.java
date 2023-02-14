package com.mjc.school.repository.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsRepositoryDataSource {
    private DataSource dataSource;

    private List<NewsDataSource> newsDataSourceList = new ArrayList<>();

    public ProjectModel create(NewsDataSource newsDataSource) {
        newsDataSourceList.add(newsDataSource);
        return new ProjectModel();
    }

    public List<NewsDataSource> readAll() {
        return newsDataSourceList;
    }

    public Optional<NewsDataSource> readBy(Long id) {
        return newsDataSourceList.stream().filter(news -> news.getId().equals(id)).findFirst();
    }

    public ProjectModel update(NewsDataSource newsDataSource) {
        newsDataSourceList.removeIf(news1 -> news1.getId().equals(newsDataSource.getId()));
        newsDataSourceList.add(newsDataSource);
        return new ProjectModel();
    }

    public Boolean delete(Long id) {
        return newsDataSourceList.removeIf(news1 -> news1.getId().equals(id));
    }
}