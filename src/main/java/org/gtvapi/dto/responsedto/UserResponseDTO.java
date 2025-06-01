package org.gtvapi.dto.responsedto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String username;

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

    public UserResponseDTO(String username) {
        this.username = username;
    }
}
