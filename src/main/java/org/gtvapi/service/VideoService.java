package org.gtvapi.service;

import org.gtvapi.mapper.VideoMapper;
import org.gtvapi.projection.VideoProjection;
import org.gtvapi.repository.VideoRepo;
import org.gtvapi.response.VideoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepo videoRepo;
    private final VideoMapper videoMapper;

    @Autowired
    public VideoService(VideoRepo videoRepo, VideoMapper videoMapper) {
        this.videoRepo = videoRepo;
        this.videoMapper = videoMapper;
    }

    public List<VideoResponse> getVideos(){
        List<VideoProjection> projections = videoRepo.getAll();
        return videoMapper.toResponseList(projections);
    }

}
