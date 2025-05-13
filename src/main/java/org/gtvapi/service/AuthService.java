package org.gtvapi.service;

import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.login.jwt.JwtUtil;
import org.gtvapi.login.jwt.model.AuthResponse;
import org.gtvapi.login.jwt.model.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse getAuthResponse(LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getUsername());

        return AuthResponse.builder()
                .token(token)
                .user(new UserResponseDTO(auth.getName())).build();
    }

}
