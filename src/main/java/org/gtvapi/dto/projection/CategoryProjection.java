package org.gtvapi.dto.projection;

import org.gtvapi.entity.Video;

import java.util.Set;

public interface CategoryProjection {

    public Long getId();
    public String getName();
    public Set<Video> getVideos();

}
