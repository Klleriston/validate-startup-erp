package com.klleriston.startupideaserp.application.dto;

import com.klleriston.startupideaserp.domain.enuns.Category;
import com.klleriston.startupideaserp.domain.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaDTO {
    private String id;
    private String title;
    private String description;
    private Category category;
    private Status status;
    private String userId;
}
