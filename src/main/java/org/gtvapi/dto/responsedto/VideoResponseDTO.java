package org.gtvapi.dto.responsedto;

import java.time.LocalTime;
import java.util.List;

public class VideoResponseDTO {

    private Long id;
    private String title;
    private String url;
    private Long view;
    private String duration;
    private Long size;
    private LocalTime publishDate;
    private Boolean ytVideo;
    private List<TagResponseDTO> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public LocalTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalTime publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getYtVideo() {
        return ytVideo;
    }

    public void setYtVideo(Boolean ytVideo) {
        this.ytVideo = ytVideo;
    }

    public List<TagResponseDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagResponseDTO> tags) {
        this.tags = tags;
    }
}
