package com.klleriston.startupideaserp.application.dto;

import com.klleriston.startupideaserp.domain.enuns.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private Role role;
    private List<String> ideasIds;
    private List<String> collaborationsIds;
}
