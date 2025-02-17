package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepositoryImpl extends MongoRepository<Comments, String> {
}
