package com.mjc.schol.service;

import com.mjc.school.repository.implementation.News;

import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T23:19:44+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News toNews(CreateNewsDTO createNewsDTO) {
        if ( createNewsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setTitle( createNewsDTO.getTitle() );
        news.setContent( createNewsDTO.getContent() );
        news.setAuthorId( createNewsDTO.getAuthorId() );

        return news;
    }

    @Override
    public NewsModelDTO toNewsDTO(News news) {
        if ( news == null ) {
            return null;
        }

        NewsModelDTO newsDTO = new NewsModelDTO();

        newsDTO.setId( news.getId() );
        newsDTO.setTitle( news.getTitle() );
        newsDTO.setContent( news.getContent() );
        if ( news.getCreatedDate() != null ) {
            newsDTO.setCreatedDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( news.getCreatedDate() ) );
        }
        if ( news.getLastUpdatedDate() != null ) {
            newsDTO.setLastUpdatedDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( news.getLastUpdatedDate() ) );
        }
        newsDTO.setAuthorId( news.getAuthorId() );

        return newsDTO;
    }

    @Override
    public News updateNews(UpdateNewsDTO updateNewsDTO) {
        if ( updateNewsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setTitle( updateNewsDTO.getTitle() );
        news.setContent( updateNewsDTO.getContent() );
        news.setAuthorId( updateNewsDTO.getAuthorId() );

        return news;
    }
}
