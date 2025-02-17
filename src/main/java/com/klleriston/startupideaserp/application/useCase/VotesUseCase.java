package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.VotesRepository;
import org.springframework.stereotype.Service;

@Service
public class VotesUseCase {
    private final VotesRepository votesRepository;

    public VotesUseCase(VotesRepository votesRepository) {
        this.votesRepository = votesRepository;
    }
}
