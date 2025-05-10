package org.gtvapi.login.jwt.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}

