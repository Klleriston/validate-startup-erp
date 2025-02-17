package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaRepositoryImpl extends MongoRepository<Idea, String> {
}
