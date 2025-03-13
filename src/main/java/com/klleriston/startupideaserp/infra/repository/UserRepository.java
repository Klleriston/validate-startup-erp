package com.klleriston.startupideaserp.infra.repository;


import com.klleriston.startupideaserp.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Query("{ '_id': ?0 }")
    @Update("{ '$push': { 'ideasIds': ?1 } }")
    void addIdeaToUser(String userId, String ideaId);

    @Query("{ '_id': ?0 }")
    @Update("{ '$pull': { 'ideasIds': ?1 } }")
    void removeIdeaFromUser(String userId, String ideaId);

    @Query("{ '_id': ?0 }")
    @Update("{ '$push': { 'collaborationsIds': ?1 } }")
    void addCollaborationToUser(String userId, String collaborationId);

    @Query("{ '_id': ?0 }")
    @Update("{ '$pull': { 'collaborationsIds': ?1 } }")
    void removeCollaborationFromUser(String userId, String collaborationId);
}
