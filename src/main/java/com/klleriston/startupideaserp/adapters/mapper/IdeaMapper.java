package com.klleriston.startupideaserp.adapters.mapper;

import com.klleriston.startupideaserp.application.dto.IdeaDTO;
import com.klleriston.startupideaserp.domain.model.Idea;

public class IdeaMapper {

    public IdeaDTO toDTO(Idea idea) {
        return new IdeaDTO(
                idea.getId(),
                idea.getTitle(),
                idea.getDescription(),
                idea.getCategory(),
                idea.getStatus(),
                idea.getUserId()
        );
    }

    public Idea toEntity(IdeaDTO ideaDTO) {
        return new Idea(
                ideaDTO.getId(),
                ideaDTO.getTitle(),
                ideaDTO.getDescription(),
                ideaDTO.getCategory(),
                ideaDTO.getStatus(),
                ideaDTO.getUserId()
        );
    }
}
