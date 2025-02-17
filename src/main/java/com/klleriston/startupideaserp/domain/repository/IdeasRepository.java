package com.klleriston.startupideaserp.domain.repository;

import com.klleriston.startupideaserp.domain.model.Idea;

import java.util.List;

public interface IdeasRepository {
    Idea save(Idea idea);
    Idea findById(String id);
    List<Idea> findAll();
    Idea update(Idea idea);
    void delete(String id);
}
