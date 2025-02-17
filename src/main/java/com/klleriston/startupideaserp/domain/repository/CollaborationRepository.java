package com.klleriston.startupideaserp.domain.repository;

import com.klleriston.startupideaserp.domain.model.Collaboration;

public interface CollaborationRepository {
    Collaboration save(Collaboration collaboration);
    Collaboration findById(String id);
    Collaboration findAll();
    Collaboration update(Collaboration collaboration);
    void delete(String id);
}
