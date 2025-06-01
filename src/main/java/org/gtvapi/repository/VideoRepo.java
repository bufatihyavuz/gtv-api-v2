package org.gtvapi.repository;

import org.gtvapi.dto.projection.VideoProjection;
import org.gtvapi.entity.Video;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepo extends JpaRepository<Video,Long> {

    @EntityGraph(attributePaths =  {"tags", "category", "user"})
    @Query(value = "SELECT v FROM Video v WHERE " +
            " v.category.code = :categoryCode OR :categoryCode IS null")
    List<VideoProjection> getAll(String categoryCode);

    @Query("SELECT ul.video FROM UserLike ul WHERE ul.user.id = :userId")
    List<VideoProjection> findVideosByUserId(@Param("userId") Long userId);

}
