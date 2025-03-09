package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Collaboration;
import com.klleriston.startupideaserp.infra.repository.CollaborationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationUseCase {
    private final CollaborationRepositoryImpl collaborationRepositoryImpl;

    @Autowired
    public CollaborationUseCase(CollaborationRepositoryImpl collaborationRepositoryImpl) {
        this.collaborationRepositoryImpl = collaborationRepositoryImpl;
    }

    public Collaboration save(Collaboration collaboration) {
        return collaborationRepositoryImpl.save(collaboration);
    }

    public List<Collaboration> listAllCollaborations() {
        return collaborationRepositoryImpl.findAll();
    }

    public Collaboration update(Collaboration collaboration) {
        Collaboration existingCollaboration = collaborationRepositoryImpl.findById(collaboration.getId()).orElseThrow(() -> new IllegalStateException("Collaboration with id " + collaboration.getId() + " not found"));

        existingCollaboration.setStatus(collaboration.getStatus());
        existingCollaboration.setMessage(collaboration.getMessage());

        return collaborationRepositoryImpl.save(existingCollaboration);
    }
}
