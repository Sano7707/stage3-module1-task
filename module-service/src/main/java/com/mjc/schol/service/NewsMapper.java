package com.mjc.schol.service;

import com.mjc.school.repository.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NewsMapper {

    @Mapping(target = "id", ignore = true)
    News toNews(CreateNewsDTO createNewsDTO);

    NewsDTO toNewsDTO(News news);

    @Mapping(target = "id", ignore = true)
    News updateNews(UpdateNewsDTO updateNewsDTO);

}
