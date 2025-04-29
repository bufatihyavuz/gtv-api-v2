package org.gtvapi.mapper;

import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.VideoResponseDTO;
import org.gtvapi.entity.Video;
import org.gtvapi.projection.VideoProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    VideoResponseDTO toResponseDTO(VideoProjection videoProjection);
    List<VideoResponseDTO> toResponseDTOList(List<VideoProjection> videoProjectionList);
    Video toEntity(VideoRequestDTO videoRequestDTO);
}
