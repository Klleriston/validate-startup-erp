package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Votes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotesRepository extends MongoRepository<Votes, String> {
}
