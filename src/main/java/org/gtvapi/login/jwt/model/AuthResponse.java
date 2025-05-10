package org.gtvapi.login.jwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthResponse {

    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
