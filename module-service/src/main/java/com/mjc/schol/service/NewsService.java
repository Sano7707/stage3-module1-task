package com.mjc.schol.service;

import com.mjc.school.repository.implementation.News;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.implementation.ProjectModel;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public NewsModelDTO createNews(CreateNewsDTO createNewsDTO) {
        News news = newsMapper.toNews(createNewsDTO);
        ProjectModel createdNews = newsRepository.create(news);
        return new NewsModelDTO();
    }

    public List<NewsModelDTO> getAllNews() {
        List<News> allNews = newsRepository.readAll();
        return allNews.stream().map(newsMapper::toNewsDTO).collect(Collectors.toList());
    }

    public NewsModelDTO getNewsById(Long id) {
        News news = newsRepository.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        return newsMapper.toNewsDTO(news);
    }

    public NewsModelDTO updateNews(Long id, UpdateNewsDTO updateNewsDTO) {
        newsRepository.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        News news;
        news = newsMapper.updateNews(updateNewsDTO);
        return new NewsModelDTO();
    }

    public boolean deleteNews(Long id) {
        News news = newsRepository.readBy(id).orElseThrow(() -> new NewsNotFoundException(id));
        return true;
    }
}
