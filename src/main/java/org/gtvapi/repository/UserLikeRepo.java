package org.gtvapi.repository;

import org.gtvapi.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepo extends JpaRepository<UserLike, Long> {

    UserLike findByUserIdAndVideoIdAndRecordStatus(long userId, long videoId, Integer recordStatus);

}

