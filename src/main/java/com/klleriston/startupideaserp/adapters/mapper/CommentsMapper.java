package com.klleriston.startupideaserp.adapters.mapper;

import com.klleriston.startupideaserp.application.dto.CommentsDTO;
import com.klleriston.startupideaserp.domain.model.Comments;

public class CommentsMapper {

    public CommentsDTO toDTO(Comments comments) {
        return new CommentsDTO(
                comments.getId(),
                comments.getUserId(),
                comments.getIdeaId(),
                comments.getIdeaId()
        );
    }

    public Comments toEntity(CommentsDTO commentsDTO) {
        return new Comments(
                commentsDTO.getId(),
                commentsDTO.getIdeaId(),
                commentsDTO.getUserId(),
                commentsDTO.getContent()
        );
    }
}
