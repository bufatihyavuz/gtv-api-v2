package org.gtvapi.common;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gtvapi.entity.User;
import org.gtvapi.login.jwt.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserContextInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public UserContextInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            Claims claims = jwtUtil.extractAllClaims(token);
            Long userId = claims.get("userId", Long.class);
            String username = claims.getSubject(); // veya claims.get("username", String.class)

            User user = User.builder().id(userId).username(username).build();
            UserContext.setCurrentUser(user);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        UserContext.clear(); // ThreadLocal temizlenmeli!
    }
}

