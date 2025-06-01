package org.gtvapi.repository;

import org.gtvapi.entity.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFollowRepo extends JpaRepository<UserFollow, Long> {

    UserFollow findByFollowerIdAndFollowedId(Long followerId, Long followedId);
}

