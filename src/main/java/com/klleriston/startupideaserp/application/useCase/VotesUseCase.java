package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Votes;
import com.klleriston.startupideaserp.infra.repository.VotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesUseCase {
    private final VotesRepository votesRepository;

    public VotesUseCase(VotesRepository votesRepository) {
        this.votesRepository = votesRepository;
    }

    public Votes save(Votes votes) {
        return votesRepository.save(votes);
    }

    public List<Votes> findAllVotes() {
        return votesRepository.findAll();
    }

    public Votes update(Votes votes) {
        Votes existingVotes = votesRepository.findById(votes.getId()).orElseThrow(() -> new RuntimeException("Votes with id" + votes.getId() + " not found"));

        existingVotes.setVote(votes.getVote());

        return votesRepository.save(existingVotes);
    }

    public void deleteVote(String id) {
        votesRepository.deleteById(id);
    }
}
