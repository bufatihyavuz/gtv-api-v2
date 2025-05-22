package org.gtvapi.mapper;

import org.gtvapi.dto.projection.CategoryProjection;
import org.gtvapi.dto.projection.VideoProjection;
import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.CategoryResponseDTO;
import org.gtvapi.dto.responsedto.VideoResponseDTO;
import org.gtvapi.entity.Video;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    @Mapping(target = "category", expression = "java(mapCategory(videoProjection.getCategory()))")
    VideoResponseDTO toResponseDTO(VideoProjection videoProjection);
    List<VideoResponseDTO> toResponseDTOList(List<VideoProjection> videoProjectionList);
    Video toEntity(VideoRequestDTO videoRequestDTO);


    // Custom dönüşüm metodu
    default CategoryResponseDTO mapCategory(CategoryProjection categoryProjection) {
        if (categoryProjection == null) return null;
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setName(categoryProjection.getName());
        dto.setId(categoryProjection.getId());
        return dto;
    }
}
