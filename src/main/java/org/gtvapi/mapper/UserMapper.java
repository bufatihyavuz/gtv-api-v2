package org.gtvapi.mapper;

import org.gtvapi.dto.projection.UserProjection;
import org.gtvapi.dto.requestdto.UserRequestDTO;
import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toResponseDTO(UserProjection userProjection);
    List<UserResponseDTO> toResponseDTOList(List<User> userList);
    User toEntity(UserRequestDTO userRequestDTO);
}
