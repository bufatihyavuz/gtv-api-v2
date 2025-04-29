package org.gtvapi.repository;

import org.gtvapi.entity.Video;
import org.gtvapi.projection.VideoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepo extends JpaRepository<Video,Long> {

    @Query(value = "SELECT v FROM Video v")
    List<VideoProjection> getAll();

    List<VideoProjection> findVideosByCategory_Id(Long categoryId);
}
