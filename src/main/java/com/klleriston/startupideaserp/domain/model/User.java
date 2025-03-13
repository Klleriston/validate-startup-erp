package com.klleriston.startupideaserp.domain.model;

import com.klleriston.startupideaserp.domain.enuns.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String name;

    private String email;

    private Role role;

    private List<String> ideasIds;

    private List<String> collaborationsIds;
}
