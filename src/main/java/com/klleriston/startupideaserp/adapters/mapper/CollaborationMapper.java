package com.klleriston.startupideaserp.adapters.mapper;

import com.klleriston.startupideaserp.application.dto.CollaborationDTO;
import com.klleriston.startupideaserp.domain.model.Collaboration;

public class CollaborationMapper {

    public CollaborationDTO toDTO(Collaboration collaboration) {
        return new CollaborationDTO(
                collaboration.getId(),
                collaboration.getIdeaId(),
                collaboration.getCollaboratorId(),
                collaboration.getMessage(),
                collaboration.getStatus()
        );
    }

    public Collaboration toEntity(CollaborationDTO collaborationDTO) {
        return new Collaboration(
                collaborationDTO.getId(),
                collaborationDTO.getIdeaId(),
                collaborationDTO.getCollaboratorId(),
                collaborationDTO.getMessage(),
                collaborationDTO.getStatus()
        );
    }
}
