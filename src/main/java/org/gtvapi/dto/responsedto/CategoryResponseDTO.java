package org.gtvapi.dto.responsedto;

import java.util.Set;

public class CategoryResponseDTO {

    private Long id;
    private String name;
    private Set<VideoResponseDTO> videos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VideoResponseDTO> getVideos() {
        return videos;
    }

    public void setVideos(Set<VideoResponseDTO> videos) {
        this.videos = videos;
    }
}
