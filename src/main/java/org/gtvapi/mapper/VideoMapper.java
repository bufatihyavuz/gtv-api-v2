package org.gtvapi.mapper;

import org.gtvapi.entity.Video;
import org.gtvapi.projection.VideoProjection;
import org.gtvapi.request.VideoRequest;
import org.gtvapi.response.VideoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    VideoResponse toResponse(VideoProjection videoProjection);
    List<VideoResponse> toResponseList(List<VideoProjection> videoProjectionList);

    Video toEntity(VideoRequest videoRequest);

}
