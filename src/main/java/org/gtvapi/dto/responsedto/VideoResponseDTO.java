package org.gtvapi.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.io.Resource;

import java.time.LocalDateTime;
import java.util.List;

public class VideoResponseDTO {

    private Long id;
    private String title;
    private String ytVideoId;
    private Long view;
    private String duration;
    private Long size;
    private LocalDateTime publishDate;
    private Boolean ytVideo;
    private List<TagResponseDTO> tags;
    private Resource channelIcon;
    private String thumbnail;
    private Integer rate;
    private CategoryResponseDTO category;
    private UserResponseDTO user;

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

    public String getYtVideoId() {
        return ytVideoId;
    }

    public void setYtVideoId(String ytVideoId) {
        this.ytVideoId = ytVideoId;
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

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }

    public Resource getChannelIcon() {
        return channelIcon;
    }

    public void setChannelIcon(Resource channelIcon) {
        this.channelIcon = channelIcon;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
