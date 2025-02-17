package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.CommentsRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentsUseCase {
    private final CommentsRepositoryImpl commentsRepositoryImpl;

    public CommentsUseCase(CommentsRepositoryImpl commentsRepositoryImpl) {
        this.commentsRepositoryImpl = commentsRepositoryImpl;
    }
}
