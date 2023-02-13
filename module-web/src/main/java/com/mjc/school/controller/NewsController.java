package com.mjc.school.controller;

import com.mjc.schol.service.CreateNewsDTO;
import com.mjc.schol.service.NewsDTO;
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
    public NewsDTO createNews(@RequestBody CreateNewsDTO createNewsDTO) {
        return newsService.createNews(createNewsDTO);
    }

    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public NewsDTO getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

    @PutMapping("/{id}")
    public NewsDTO updateNews(@PathVariable Long id, @RequestBody UpdateNewsDTO updateNewsDTO) {
        return newsService.updateNews(id, updateNewsDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNews(@PathVariable Long id) {
        return newsService.deleteNews(id);
    }
}
