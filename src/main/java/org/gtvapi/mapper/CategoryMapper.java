package org.gtvapi.mapper;

import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.CategoryResponseDTO;
import org.gtvapi.entity.Category;
import org.gtvapi.entity.Video;
import org.gtvapi.projection.CategoryProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO toResponseDTO(CategoryProjection categoryProjection);
    List<CategoryResponseDTO> toResponseDTOList(List<Category> categoryList);
    Video toEntity(VideoRequestDTO videoRequestDTO);
}
