package com.mjc.school.repository.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class NewsDataSource {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private Long authorId;
    private DataSource dataSource;

    public NewsDataSource() {
    }

    public NewsDataSource(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.lastUpdatedDate = LocalDateTime.now();
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", authorId=" + authorId +
                '}';
    }

    public ProjectModel create(ProjectModel news) {
        return new ProjectModel();
    }

    public List<NewsDataSource> readAll() {
        return new ArrayList<>();
    }

    public ProjectModel readBy(Long id) {
        return new ProjectModel();
    }

    public ProjectModel update(ProjectModel news) {
        return new ProjectModel();
    }

    public Boolean delete(Long id) {
        return true;
    }
}