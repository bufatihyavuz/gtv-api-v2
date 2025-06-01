package org.gtvapi.service;

import org.gtvapi.common.UserContext;
import org.gtvapi.dto.projection.UserProjection;
import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.entity.User;
import org.gtvapi.mapper.UserMapper;
import org.gtvapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserResponseDTO> myFollowings() {
        User followerUser = UserContext.getCurrentUser();
        return userMapper.toResponseDTOList(userRepository.myFollowingUsers(followerUser.getId()));
    }
}
