package org.gtvapi.dto.responsedto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String username;
    private Boolean approved;
    private String userIcon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public UserResponseDTO(String username) {
        this.username = username;
    }

    public String getChannelIconName() {
        return userIcon;
    }

    public void setChannelIconName(String userIcon) {
        this.userIcon = userIcon;
    }
}
