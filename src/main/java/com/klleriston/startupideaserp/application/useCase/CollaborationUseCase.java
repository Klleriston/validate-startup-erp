package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Collaboration;
import com.klleriston.startupideaserp.infra.repository.CollaborationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationUseCase {
    private final CollaborationRepository collaborationRepository;

    @Autowired
    public CollaborationUseCase(CollaborationRepository collaborationRepository) {
        this.collaborationRepository = collaborationRepository;
    }

    public Collaboration save(Collaboration collaboration) {
        return collaborationRepository.save(collaboration);
    }

    public List<Collaboration> listAllCollaborations() {
        return collaborationRepository.findAll();
    }

    public Collaboration findById(String id) {
        return collaborationRepository.findById(id).orElse(null);
    }

    public Collaboration update(Collaboration collaboration) {
        Collaboration existingCollaboration = collaborationRepository.findById(collaboration.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "Collaboration with id " + collaboration.getId() + " not found"));

        existingCollaboration.setStatus(collaboration.getStatus());
        existingCollaboration.setMessage(collaboration.getMessage());

        return collaborationRepository.save(existingCollaboration);
    }

    public void delete(String id) {
        collaborationRepository.deleteById(id);
    }
}
