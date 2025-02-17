package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.IdeaRepository;
import org.springframework.stereotype.Service;

@Service
public class IdeaUseCase {
    private final IdeaRepository ideaRepository;

    public IdeaUseCase(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }
}
