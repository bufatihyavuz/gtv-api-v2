package org.gtvapi.service;

import org.gtvapi.dto.projection.UserProjection;
import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.mapper.UserMapper;
import org.gtvapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO findByUsername(String username) {
        UserProjection userProjection = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));
        return userMapper.toResponseDTO(userProjection);
    }

}
