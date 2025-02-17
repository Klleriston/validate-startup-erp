package com.klleriston.startupideaserp.application.dto;

import com.klleriston.startupideaserp.domain.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaborationDTO {
    private String id;
    private String ideaId;
    private String collaboratorId;
    private String message;
    private Status status;
}
