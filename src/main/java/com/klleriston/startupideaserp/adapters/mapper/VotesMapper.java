package com.klleriston.startupideaserp.adapters.mapper;

import com.klleriston.startupideaserp.application.dto.VotesDTO;
import com.klleriston.startupideaserp.domain.model.Votes;

public class VotesMapper {

    public VotesDTO toDTO(Votes votes) {
        return new VotesDTO(
                votes.getId(),
                votes.getUserId(),
                votes.getIdeaId(),
                votes.getVote()
        );
    }

    public Votes toEntity(VotesDTO votesDTO) {
        return new Votes(
                votesDTO.getId(),
                votesDTO.getUserId(),
                votesDTO.getIdeaId(),
                votesDTO.getVote()
        );
    }
}
