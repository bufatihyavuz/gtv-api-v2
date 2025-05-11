package org.gtvapi.dto.projection;

import org.gtvapi.entity.Category;
import org.gtvapi.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

public interface VideoProjection {

    public Long getId();
    public String getTitle();
    public String getUrl();
    public Long getView();
    public String getDuration();
    public Long getSize();
    public LocalDateTime getPublishDate();
    public Boolean getYtVideo();
    public Category getCategoryId();
    public User getUserId();
    public Set<TagProjection> getTags();

}
