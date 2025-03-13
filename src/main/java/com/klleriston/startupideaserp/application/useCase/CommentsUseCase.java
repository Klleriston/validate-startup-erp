package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Comments;
import com.klleriston.startupideaserp.infra.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsUseCase {
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsUseCase(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comments save(Comments comments) {
        return commentsRepository.save(comments);
    }

    public List<Comments> FindAllComments() {
        return commentsRepository.findAll();
    }

    public Comments update(Comments comments) {
        Comments existingComments = commentsRepository.findById(comments.getId()).orElseThrow(() -> new IllegalArgumentException("Comment with id " + comments.getId() + " not found"));
        existingComments.setContent(comments.getContent());
        return commentsRepository.save(existingComments);
    }

    public void deleteComment(String id) {
        commentsRepository.deleteById(id);
    }
}
