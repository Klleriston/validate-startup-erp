package com.klleriston.startupideaserp.application.dto;

import com.klleriston.startupideaserp.domain.enuns.VoteType;
import com.klleriston.startupideaserp.domain.model.Idea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotesDTO {
    private String id;
    private String userId;
    private Idea ideaId;
    private VoteType vote;
}
