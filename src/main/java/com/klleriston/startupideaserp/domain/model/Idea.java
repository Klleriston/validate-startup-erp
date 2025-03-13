package com.klleriston.startupideaserp.domain.model;

import com.klleriston.startupideaserp.domain.enuns.Category;
import com.klleriston.startupideaserp.domain.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ideas")
@NoArgsConstructor
@AllArgsConstructor
public class Idea {
    @Id
    private String id;

    private String title;

    private String description;

    private Category category;

    private Status status;

    @Indexed
    private String userId;

    public Idea(String id) {
        this.id = id;
    }
}
