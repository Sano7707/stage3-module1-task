package com.mjc.schol.service;

import com.mjc.school.repository.implementation.NewsDataSource;

import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T23:19:44+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDataSource toNews(CreateNewsDTO createNewsDTO) {
        if ( createNewsDTO == null ) {
            return null;
        }

        NewsDataSource newsDataSource = new NewsDataSource();

        newsDataSource.setTitle( createNewsDTO.getTitle() );
        newsDataSource.setContent( createNewsDTO.getContent() );
        newsDataSource.setAuthorId( createNewsDTO.getAuthorId() );

        return newsDataSource;
    }

    @Override
    public NewsModelDTO toNewsDTO(NewsDataSource newsDataSource) {
        if ( newsDataSource == null ) {
            return null;
        }

        NewsModelDTO newsDTO = new NewsModelDTO();

        newsDTO.setId( newsDataSource.getId() );
        newsDTO.setTitle( newsDataSource.getTitle() );
        newsDTO.setContent( newsDataSource.getContent() );
        if ( newsDataSource.getCreatedDate() != null ) {
            newsDTO.setCreatedDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( newsDataSource.getCreatedDate() ) );
        }
        if ( newsDataSource.getLastUpdatedDate() != null ) {
            newsDTO.setLastUpdatedDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( newsDataSource.getLastUpdatedDate() ) );
        }
        newsDTO.setAuthorId( newsDataSource.getAuthorId() );

        return newsDTO;
    }

    @Override
    public NewsDataSource updateNews(UpdateNewsDTO updateNewsDTO) {
        if ( updateNewsDTO == null ) {
            return null;
        }

        NewsDataSource newsDataSource = new NewsDataSource();

        newsDataSource.setTitle( updateNewsDTO.getTitle() );
        newsDataSource.setContent( updateNewsDTO.getContent() );
        newsDataSource.setAuthorId( updateNewsDTO.getAuthorId() );

        return newsDataSource;
    }
}
