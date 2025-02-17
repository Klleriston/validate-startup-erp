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
                user.getIdeasIds().stream()
                        .map(Idea::getId)
                        .collect(Collectors.toList()),
                user.getCollaborationsIds().stream()
                        .map(Collaboration::getId)
                        .collect(Collectors.toList())
        );
    }

    public User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getIdeasIds().stream()
                        .map(Idea::new)
                        .collect(Collectors.toList()),
                userDTO.getCollaborationsIds().stream()
                        .map(Collaboration::new)
                        .collect(Collectors.toList())
        );
    }
}
