package org.gtvapi.login.jwt.model;

import lombok.*;
import org.gtvapi.dto.responsedto.UserResponseDTO;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private UserResponseDTO user;

}
