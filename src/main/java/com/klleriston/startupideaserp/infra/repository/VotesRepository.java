package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Votes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VotesRepository extends MongoRepository<Votes, String> {
    List<Votes> findByIdeaId(String ideaId);
    List<Votes> findByUserId(String userId);
    Optional<Votes> findByUserIdAndIdeaId(String userId, String ideaId);
}
