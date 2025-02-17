package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Collaboration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollaborationRepositoryImpl extends MongoRepository<Collaboration, String> {
}
