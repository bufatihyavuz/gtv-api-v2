package org.gtvapi.service;

import ch.qos.logback.core.util.StringUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtvapi.EntityStatus;
import org.gtvapi.common.UserContext;
import org.gtvapi.dto.projection.VideoProjection;
import org.gtvapi.dto.requestdto.VideoRequestDTO;
import org.gtvapi.dto.responsedto.VideoResponseDTO;
import org.gtvapi.entity.*;
import org.gtvapi.mapper.VideoMapper;
import org.gtvapi.repository.VideoRepo;
import org.gtvapi.util.DateUtil;
import org.gtvapi.util.YotubeUtil;
import org.gtvapi.youtubeAPI.ContentDetails;
import org.gtvapi.youtubeAPI.Snippet;
import org.gtvapi.youtubeAPI.Statistics;
import org.gtvapi.youtubeAPI.YtVideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VideoService {

    private static final Logger logger = LogManager.getLogger(VideoService.class);


    private final VideoRepo videoRepo;
    private final VideoMapper videoMapper;
    private final UserLikeService userLikeService;

    public List<VideoResponseDTO> getVideos(String categoryCode){
        logger.info("videoservice");
        List<VideoProjection> projections = videoRepo.getAll(categoryCode);
        return videoMapper.toResponseDTOList(projections);
    }

    public void saveVideo(VideoRequestDTO videoRequestDTO){
        User user = UserContext.getCurrentUser();
        Video video = fillVideoDTOByYoutubeApi(videoRequestDTO.getYtVideoId());
        video.setCategory(videoRequestDTO.getCategoryId() != null ? new Category(videoRequestDTO.getCategoryId()) : null);
        video.setUser(user);
        videoRepo.save(video);
    }

    private Video fillVideoDTOByYoutubeApi(String ytVideoId) {

        try {
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
            video.setPublishDate(DateUtil.toLocalTime(snippet.getPublishedAt()));
            video.setTags(!CollectionUtils.isEmpty(snippet.getTags()) ? snippet.getTags().stream().map(Tag::new).collect(Collectors.toUnmodifiableSet()) : null);
            video.setYtVideo(true);
            video.setYtVideoId(ytVideoId);
            video.setThumbnail(snippet.getThumbnails().getMedium().getUrl());
            return video;
        } catch (org.gtvapi.exception.IOException.WrongParameters | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ResponseEntity<YtVideoDTO> callYoutubeAPI(String requestURL) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<YtVideoDTO> ytVideoDTO = restTemplate
                .getForEntity(requestURL, YtVideoDTO.class);
        return ytVideoDTO;
    }

    public void likeVideo(Long videoId) {
        User user = UserContext.getCurrentUser();
        UserLike userLike = userLikeService.getUserLike(user.getId(), videoId);
        if(userLike != null){
            userLikeService.dislikeVideo(userLike.getId());
        }else {
            userLikeService.likeVideo(user.getId(), videoId);
        }
    }

    public Boolean isLikeVideo(Long videoId) {
        User user = UserContext.getCurrentUser();
        UserLike userLike = userLikeService.getUserLike(user.getId(), videoId);
        return userLike != null;
    }

    public List<VideoResponseDTO> myLikeVideos() {
        User user = UserContext.getCurrentUser();
        return videoMapper.toResponseDTOList(videoRepo.findLikedVideosByUserId(user.getId()));
    }

    public List<VideoResponseDTO> fetchVideosFromFollowedUsers() {
        User user = UserContext.getCurrentUser();
        return videoMapper.toResponseDTOList(videoRepo.fetchVideosFromFollowedUsers(user.getId()));
    }

    @Transactional
    public void deleteVideo(Long videoId) {
        videoRepo.deleteVideoById(videoId, EntityStatus.DELETED.getCode());
    }

    public List<VideoResponseDTO> myVideos() {
        User user = UserContext.getCurrentUser();
        return videoMapper.toResponseDTOList(videoRepo.myVideos(user.getId()));
    }
}
