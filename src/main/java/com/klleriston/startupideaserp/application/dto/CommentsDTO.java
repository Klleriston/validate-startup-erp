package com.klleriston.startupideaserp.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO {
    private String id;
    private String ideaId;
    private String userId;
    private String content;
}
