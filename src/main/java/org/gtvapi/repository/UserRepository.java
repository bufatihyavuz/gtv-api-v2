package org.gtvapi.repository;

import org.gtvapi.dto.projection.UserProjection;
import org.gtvapi.dto.projection.VideoProjection;
import org.gtvapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserProjection> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query("SELECT uf.followed FROM UserFollow uf WHERE uf.follower.id = :userId")
    List<UserProjection> myFollowingUsers(@Param("userId") Long userId);
}

