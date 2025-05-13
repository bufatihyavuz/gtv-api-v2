package org.gtvapi.dto.responsedto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponseDTO {

    private String username;

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
