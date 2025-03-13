package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Collaboration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CollaborationRepository extends MongoRepository<Collaboration, String> {
    List<Collaboration> findByCollaboratorId(String collaboratorId);
    List<Collaboration> findByIdeaId(String ideaId);
}