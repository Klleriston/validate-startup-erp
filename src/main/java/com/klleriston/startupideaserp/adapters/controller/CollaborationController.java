package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.CollaborationUseCase;
import com.klleriston.startupideaserp.domain.model.Collaboration;
import com.klleriston.startupideaserp.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaboration")
public class CollaborationController {
    private final CollaborationUseCase collaborationUseCase;
    private final UserRepository userRepository;

    @Autowired
    public CollaborationController(CollaborationUseCase collaborationUseCase, UserRepository userRepository) {
        this.collaborationUseCase = collaborationUseCase;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Collaboration> saveCollaboration(@RequestBody Collaboration collaboration) {
        if (collaboration.getCollaboratorId() != null &&
                userRepository.existsById(collaboration.getCollaboratorId())) {
            Collaboration collaborationSaved = collaborationUseCase.save(collaboration);
            userRepository.addCollaborationToUser(
                    collaboration.getCollaboratorId(),
                    collaborationSaved.getId()
            );
            return new ResponseEntity<>(collaborationSaved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Collaboration>> getAllCollaborations() {
        List<Collaboration> collaborations = collaborationUseCase.listAllCollaborations();
        return new ResponseEntity<>(collaborations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collaboration> updateCollaboration( @PathVariable String id, @RequestBody Collaboration collaboration) {
        collaboration.setId(id);
        Collaboration updateCollaboration = collaborationUseCase.update(collaboration);
        return new ResponseEntity<>(updateCollaboration, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollaboration(@PathVariable String id) {
        Collaboration collaboration = collaborationUseCase.findById(id);
        if (collaboration != null && collaboration.getCollaboratorId() != null) {
            userRepository.removeCollaborationFromUser(
                    collaboration.getCollaboratorId(),
                    id
            );
        }

        collaborationUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
