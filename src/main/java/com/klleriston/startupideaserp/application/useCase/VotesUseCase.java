package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.VotesRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class VotesUseCase {
    private final VotesRepositoryImpl votesRepositoryImpl;

    public VotesUseCase(VotesRepositoryImpl votesRepositoryImpl) {
        this.votesRepositoryImpl = votesRepositoryImpl;
    }
}
