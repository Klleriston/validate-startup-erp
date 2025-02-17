package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.IdeaRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class IdeaUseCase {
    private final IdeaRepositoryImpl ideaRepositoryImpl;

    public IdeaUseCase(IdeaRepositoryImpl ideaRepositoryImpl) {
        this.ideaRepositoryImpl = ideaRepositoryImpl;
    }
}
