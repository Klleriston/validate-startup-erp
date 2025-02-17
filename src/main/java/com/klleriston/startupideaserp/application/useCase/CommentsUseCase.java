package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.CommentsRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentsUseCase {
    private final CommentsRepository commentsRepository;

    public CommentsUseCase(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
