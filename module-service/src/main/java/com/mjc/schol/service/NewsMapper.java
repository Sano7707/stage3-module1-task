package com.mjc.schol.service;

import com.mjc.school.repository.implementation.NewsDataSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NewsMapper {

    @Mapping(target = "id", ignore = true)
    NewsDataSource toNews(CreateNewsDTO createNewsDTO);

    NewsModelDTO toNewsDTO(NewsDataSource newsDataSource);

    @Mapping(target = "id", ignore = true)
    NewsDataSource updateNews(UpdateNewsDTO updateNewsDTO);

}
