package com.klleriston.startupideaserp.domain.repository;

import com.klleriston.startupideaserp.domain.model.Votes;

import java.util.List;

public interface VotesRepository {
    Votes save(Votes votes);
    Votes findById(String id);
    List<Votes> findAll();
    Votes update(Votes votes);
    void deleteById(String id);
}
