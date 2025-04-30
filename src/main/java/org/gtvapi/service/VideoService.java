package org.gtvapi.service;

import ch.qos.logback.core.util.StringUtil;
import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.VideoResponseDTO;
import org.gtvapi.youtubeAPI.ContentDetails;
import org.gtvapi.youtubeAPI.Snippet;
import org.gtvapi.youtubeAPI.Statistics;
import org.gtvapi.youtubeAPI.YtVideoDTO;
import org.gtvapi.entity.Category;
import org.gtvapi.entity.Tag;
import org.gtvapi.entity.Video;
import org.gtvapi.mapper.VideoMapper;
import org.gtvapi.dto.projection.VideoProjection;
import org.gtvapi.repository.VideoRepo;
import org.gtvapi.util.YotubeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private final VideoRepo videoRepo;
    private final VideoMapper videoMapper;

    @Autowired
    public VideoService(VideoRepo videoRepo, VideoMapper videoMapper) {
        this.videoRepo = videoRepo;
        this.videoMapper = videoMapper;
    }

    public List<VideoResponseDTO> getVideos(){
        List<VideoProjection> projections = videoRepo.getAll();
        return videoMapper.toResponseDTOList(projections);
    }

    public void saveVideo(VideoRequestDTO videoRequestDTO)  throws org.gtvapi.exception.IOException.WrongParameters,IOException {
        Video video = fillVideoDTOByYoutubeApi(videoRequestDTO.getYtVideoId());
        video.setCategory(videoRequestDTO.getCategoryId() != null ? new Category(videoRequestDTO.getCategoryId()) : null);
        videoRepo.save(video);
    }

    private Video fillVideoDTOByYoutubeApi(String ytVideoId) throws org.gtvapi.exception.IOException.WrongParameters, IOException {
        if(StringUtil.isNullOrEmpty(ytVideoId)){
            throw new org.gtvapi.exception.IOException.WrongParameters("WrongParameters Exception");
        }

        String requestURL = YotubeUtil.generateYoutubeApiRequestURL(ytVideoId,"snippet,statistics,contentDetails");
        ResponseEntity<YtVideoDTO> ytVideoDTO = callYoutubeAPI(requestURL);

        ContentDetails contentDetails = ytVideoDTO.getBody().getItems().get(0).getContentDetails();
        Snippet snippet = ytVideoDTO.getBody().getItems().get(0).getSnippet();
        Statistics statistics = ytVideoDTO.getBody().getItems().get(0).getStatistics();

        Video video = new Video();
        video.setTitle(snippet.getTitle());
        video.setView(Long.valueOf(statistics.getViewCount()));
        video.setDuration(contentDetails.getDuration());
        DateTimeFormatter f = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
        video.setPublishDate(LocalTime.from(LocalDateTime.parse(snippet.getPublishedAt(), f)));
        video.setTags(!CollectionUtils.isEmpty(snippet.getTags()) ? snippet.getTags().stream().map(Tag::new).collect(Collectors.toUnmodifiableSet()) : null);
        video.setYtVideo(true);
        video.setUrl(ytVideoId);
        return video;
    }

    private ResponseEntity<YtVideoDTO> callYoutubeAPI(String requestURL) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<YtVideoDTO> ytVideoDTO = restTemplate
                .getForEntity(requestURL, YtVideoDTO.class);
        return ytVideoDTO;
    }

    public List<VideoResponseDTO> getVideosByCategoryId(Long categoryId) {
        List<VideoProjection> videoList = videoRepo.findVideosByCategory_Id(categoryId);
        return videoMapper.toResponseDTOList(videoList);
    }
}
