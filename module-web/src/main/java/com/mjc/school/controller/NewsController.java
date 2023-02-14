package com.mjc.school.controller;

import com.mjc.schol.service.CreateNewsDTO;
import com.mjc.schol.service.NewsModelDTO;
import com.mjc.schol.service.NewsService;
import com.mjc.schol.service.UpdateNewsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public NewsModelDTO createNews(@RequestBody CreateNewsDTO createNewsDTO) {
        return newsService.createNews(createNewsDTO);
    }

    @GetMapping
    public List<NewsModelDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public NewsModelDTO getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

    @PutMapping("/{id}")
    public NewsModelDTO updateNews(@PathVariable Long id, @RequestBody UpdateNewsDTO updateNewsDTO) {
        return newsService.updateNews(id, updateNewsDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNews(@PathVariable Long id) {
        return newsService.deleteNews(id);
    }
}
