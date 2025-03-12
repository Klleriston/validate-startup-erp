package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.CollaborationUseCase;
import com.klleriston.startupideaserp.domain.model.Collaboration;
import com.klleriston.startupideaserp.domain.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaboartion")
public class CollaborationController {
    private final CollaborationUseCase collaborationUseCase;

    @Autowired
    public CollaborationController(CollaborationUseCase collaborationUseCase) {
        this.collaborationUseCase = collaborationUseCase;
    }

    @PostMapping
    public ResponseEntity<Collaboration> saveCollaboration(@RequestBody Collaboration collaboration) {
        Collaboration collaborationSaved = collaborationUseCase.save(collaboration);
        return new ResponseEntity<>(collaborationSaved, HttpStatus.CREATED);
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
    public ResponseEntity<Collaboration> deleteCollaboration(@PathVariable String id, @RequestBody Collaboration collaboration) {
        collaborationUseCase.delete(id);
        return new ResponseEntity<>(collaboration, HttpStatus.NO_CONTENT);
    }
}
