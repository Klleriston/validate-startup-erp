package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Comments;
import com.klleriston.startupideaserp.infra.repository.CommentsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsUseCase {
    private final CommentsRepositoryImpl commentsRepositoryImpl;

    @Autowired
    public CommentsUseCase(CommentsRepositoryImpl commentsRepositoryImpl) {
        this.commentsRepositoryImpl = commentsRepositoryImpl;
    }

    public Comments save(Comments comments) {
        return commentsRepositoryImpl.save(comments);
    }

    public List<Comments> FindAllComments() {
        return commentsRepositoryImpl.findAll();
    }

    public Comments update(Comments comments) {
        Comments existingComments = commentsRepositoryImpl.findById(comments.getId()).orElseThrow(() -> new IllegalArgumentException("Comment with id " + comments.getId() + " not found"));

        existingComments.setContent(comments.getContent());

        return commentsRepositoryImpl.save(existingComments);
    }

    public void deleteComment(String id) {
        commentsRepositoryImpl.deleteById(id);
    }
}
