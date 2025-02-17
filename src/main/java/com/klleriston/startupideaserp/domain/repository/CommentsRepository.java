package com.klleriston.startupideaserp.domain.repository;

import com.klleriston.startupideaserp.domain.model.Comments;

public interface CommentsRepository {
    Comments save(Comments comments);
    Comments findById(String id);
    Comments findAll();
    Comments update(Comments comments);
    void delete(String id);
}
