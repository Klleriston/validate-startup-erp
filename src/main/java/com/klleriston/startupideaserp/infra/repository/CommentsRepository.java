package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentsRepository extends MongoRepository<Comments, String> {
    List<Comments> findByIdeaId(String ideaId);
    List<Comments> findByUserId(String userId);
}
