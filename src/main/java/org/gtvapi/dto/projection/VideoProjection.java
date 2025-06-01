package org.gtvapi.dto.projection;

import org.gtvapi.entity.Category;
import org.gtvapi.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

public interface VideoProjection {

    public Long getId();
    public String getTitle();
    public String getYtVideoId();
    public Long getView();
    public String getDuration();
    public Long getSize();
    public LocalDateTime getPublishDate();
    public Boolean getYtVideo();
    public UserProjection getUser();
    public Set<TagProjection> getTags();
    public String getChannelName();
    public String getChannelIconName();
    public String getThumbnail();
    public Integer getRate();
    public CategoryProjection getCategory();

}
