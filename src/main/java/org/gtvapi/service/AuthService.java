package org.gtvapi.service;

import lombok.RequiredArgsConstructor;
import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.login.jwt.JwtUtil;
import org.gtvapi.login.jwt.model.AuthResponse;
import org.gtvapi.login.jwt.model.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthResponse getAuthResponse(LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserResponseDTO userResponseDTO = userService.findByUsername(request.getUsername());

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userResponseDTO.getId());
        //claims.put("role", userResponseDTO.getRole());

        String token = jwtUtil.generateToken(claims, userResponseDTO.getUsername());

        return AuthResponse.builder()
                .token(token)
                .user(new UserResponseDTO(auth.getName())).build();
    }

}
