package org.gtvapi.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtvapi.common.UserContext;
import org.gtvapi.entity.User;
import org.gtvapi.entity.UserFollow;
import org.gtvapi.repository.UserFollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserFollowService {

    private static final Logger logger = LogManager.getLogger(UserFollowService.class);

    private final UserFollowRepo userFollowRepo;

    public void followUser(Long followedId) {

        User followerUser = UserContext.getCurrentUser();

        UserFollow userFollow = getUserFollow(followerUser.getId(), followedId);

        if(userFollow != null){
            userFollowRepo.delete(userFollow);
        }else {
            saveUserFollow(followerUser.getId(), followedId);
        }
    }

    private void saveUserFollow(Long followedId, Long followerId) {
        UserFollow userFollow = UserFollow.builder()
                .follower(new User(followerId))
                .followed(new User(followedId))
                .build();
        userFollowRepo.save(userFollow);
    }

    public UserFollow getUserFollow(Long followerId, Long followedId) {
        return userFollowRepo.findByFollowerIdAndFollowedId(followerId, followedId);
    }

    public Boolean isUserFollow(Long followedId) {
        User followerUser = UserContext.getCurrentUser();
        return getUserFollow(followerUser.getId(), followedId) != null;
    }

}
