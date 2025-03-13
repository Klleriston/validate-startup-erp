package com.klleriston.startupideaserp.infra.repository;

import com.klleriston.startupideaserp.domain.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    List<Idea> findByUserId(String userId);

    @Query(value = "{ 'category': ?0 }")
    List<Idea> findByCategory(String category);

    @Query(value = "{ 'status': ?0 }")
    List<Idea> findByStatus(String status);
}
