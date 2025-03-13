package com.klleriston.startupideaserp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    private String id;

    @Indexed
    private String ideaId;

    @Indexed
    private String userId;

    private String content;
}
