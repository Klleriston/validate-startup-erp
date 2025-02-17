package com.klleriston.startupideaserp.domain.model;

import com.klleriston.startupideaserp.domain.enuns.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "votes")
@NoArgsConstructor
@AllArgsConstructor
public class Votes {
    @Id
    private String id;

    private String userId;

    private Idea idea;

    private VoteType vote;
}
