package com.klleriston.startupideaserp.infra.repository;


import com.klleriston.startupideaserp.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
