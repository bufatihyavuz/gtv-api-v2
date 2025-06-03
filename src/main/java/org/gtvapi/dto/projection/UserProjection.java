package org.gtvapi.dto.projection;

public interface UserProjection {

    Long getId();
    Boolean getApproved();
    String getUsername();
    String getPassword();
    String getChannelName();
    String getChannelIconName();
}
