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
    private LocalTime createDate;
    private Boolean ytVideo;
    private List<TagResponseDTO> tags;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Long getView() {
        return view;
    }

    public String getDuration() {
        return duration;
    }

    public Long getSize() {
        return size;
    }

    public LocalTime getCreateDate() {
        return createDate;
    }

    public Boolean getYtVideo() {
        return ytVideo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setView(Long view) {
        this.view = view;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setCreateDate(LocalTime createDate) {
        this.createDate = createDate;
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
