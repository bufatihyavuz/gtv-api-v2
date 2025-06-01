package org.gtvapi.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtvapi.entity.User;
import org.gtvapi.entity.UserLike;
import org.gtvapi.entity.Video;
import org.gtvapi.repository.UserLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserLikeService {

    private static final Logger logger = LogManager.getLogger(UserLikeService.class);

    private final UserLikeRepo userLikeRepo;

    public void likeVideo(Long userId, Long videoId) {
        UserLike userLike = UserLike.builder().video(new Video(videoId)).user(new User(userId)).liked(true).build();
        userLikeRepo.save(userLike);
    }

    public void dislikeVideo(Long userLikeId) {
        userLikeRepo.delete(new UserLike(userLikeId));
    }

    public UserLike getUserLike(Long userId, Long videoId) {
        return userLikeRepo.findByUserIdAndVideoIdAndRecordStatus(userId, videoId, 1);
    }

}
