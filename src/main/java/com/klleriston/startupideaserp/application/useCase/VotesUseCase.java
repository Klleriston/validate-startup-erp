package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Votes;
import com.klleriston.startupideaserp.infra.repository.VotesRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesUseCase {
    private final VotesRepositoryImpl votesRepositoryImpl;

    public VotesUseCase(VotesRepositoryImpl votesRepositoryImpl) {
        this.votesRepositoryImpl = votesRepositoryImpl;
    }

    public Votes save(Votes votes) {
        return votesRepositoryImpl.save(votes);
    }

    public List<Votes> findAllVotes() {
        return votesRepositoryImpl.findAll();
    }

    public Votes update(Votes votes) {
        Votes existingVotes = votesRepositoryImpl.findById(votes.getId()).orElseThrow(() -> new RuntimeException("Votes with id" + votes.getId() + " not found"));

        existingVotes.setVote(votes.getVote());

        return votesRepositoryImpl.save(existingVotes);
    }

    public void deleteVote(String id) {
        votesRepositoryImpl.deleteById(id);
    }
}
