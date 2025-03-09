package com.klleriston.startupideaserp.adapters.mapper;

import com.klleriston.startupideaserp.application.dto.UserDTO;
import com.klleriston.startupideaserp.domain.model.Collaboration;
import com.klleriston.startupideaserp.domain.model.Idea;
import com.klleriston.startupideaserp.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getIdeasIds(),
                user.getCollaborationsIds()
        );
    }

    public User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getIdeasIds(),
                userDTO.getCollaborationsIds()
        );
    }
}
