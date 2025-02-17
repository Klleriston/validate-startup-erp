package com.klleriston.startupideaserp.application.useCase;

import org.springframework.stereotype.Service;

@Service
public class CollaborationUseCase {
    private final IdeaUseCase ideaUseCase;

    public CollaborationUseCase(IdeaUseCase ideaUseCase) {
        this.ideaUseCase = ideaUseCase;
    }
}
