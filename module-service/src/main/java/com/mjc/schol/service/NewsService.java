package com.mjc.schol.service;

import com.mjc.school.repository.implementation.NewsDataSource;
import com.mjc.school.repository.implementation.NewsRepositoryDataSource;
import com.mjc.school.repository.implementation.ProjectModel;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepositoryDataSource newsRepositoryDataSource;
    private final NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);

    public NewsService(NewsRepositoryDataSource newsRepositoryDataSource) {
        this.newsRepositoryDataSource = newsRepositoryDataSource;
    }

    public NewsModelDTO createNews(CreateNewsDTO createNewsDTO) {
        NewsDataSource newsDataSource = newsMapper.toNews(createNewsDTO);
        ProjectModel createdNews = newsRepositoryDataSource.create(newsDataSource);
        return new NewsModelDTO();
    }

    public List<NewsModelDTO> getAllNews() {
        List<NewsDataSource> allNews = newsRepositoryDataSource.readAll();
        return allNews.stream().map(newsMapper::toNewsDTO).collect(Collectors.toList());
    }

    public NewsModelDTO getNewsById(Long id) {
        NewsDataSource newsDataSource = newsRepositoryDataSource.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        return newsMapper.toNewsDTO(newsDataSource);
    }

    public NewsModelDTO updateNews(Long id, UpdateNewsDTO updateNewsDTO) {
        newsRepositoryDataSource.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        NewsDataSource newsDataSource;
        newsDataSource = newsMapper.updateNews(updateNewsDTO);
        return new NewsModelDTO();
    }

    public boolean deleteNews(Long id) {
        NewsDataSource newsDataSource = newsRepositoryDataSource.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        return true;
    }
}
