package com.mjc.schol.service;

import com.mjc.school.repository.implementation.News;
import com.mjc.school.repository.implementation.NewsRepository;
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

    public NewsDTO createNews(CreateNewsDTO createNewsDTO) {
        News news = newsMapper.toNews(createNewsDTO);
        News createdNews = newsRepository.createNews(news);
        return newsMapper.toNewsDTO(createdNews);
    }

    public List<NewsDTO> getAllNews() {
        List<News> allNews = newsRepository.getAllNews();
        return allNews.stream().map(newsMapper::toNewsDTO).collect(Collectors.toList());
    }

    public NewsDTO getNewsById(Long id) {
        News news = newsRepository.getNewsById(id).orElseThrow(() -> new NewsNotFoundException(id));
        return newsMapper.toNewsDTO(news);
    }

    public NewsDTO updateNews(Long id, UpdateNewsDTO updateNewsDTO) {
        newsRepository.getNewsById(id).orElseThrow(() -> new NewsNotFoundException(id));
        News news;
        news = newsMapper.updateNews(updateNewsDTO);
        news = newsRepository.updateNews(news);
        return newsMapper.toNewsDTO(news);
    }

    public boolean deleteNews(Long id) {
        News news = newsRepository.getNewsById(id).orElseThrow(() -> new NewsNotFoundException(id));
        newsRepository.deleteNews(news);
        return true;
    }
}
