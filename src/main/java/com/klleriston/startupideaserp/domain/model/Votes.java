package com.klleriston.startupideaserp.domain.model;

import com.klleriston.startupideaserp.domain.enuns.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "votes")
@NoArgsConstructor
@AllArgsConstructor
public class Votes {
    @Id
    private String id;

    @Indexed
    private String userId;

    @Indexed
    private String ideaId;

    private VoteType vote;
}
