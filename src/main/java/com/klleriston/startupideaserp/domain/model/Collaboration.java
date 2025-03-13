package com.klleriston.startupideaserp.domain.model;

import com.klleriston.startupideaserp.domain.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "collaborations")
@NoArgsConstructor
@AllArgsConstructor
public class Collaboration {
    @Id
    private String id;

    private String ideaId;

    @Indexed
    private String collaboratorId;

    private String message;

    private Status status;

    public Collaboration(String id) {
        this.id = id;
    }
}
