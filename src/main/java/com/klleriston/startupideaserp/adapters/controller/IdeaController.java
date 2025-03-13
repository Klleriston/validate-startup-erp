package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.IdeaUseCase;
import com.klleriston.startupideaserp.domain.model.Idea;
import com.klleriston.startupideaserp.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idea")
public class IdeaController {
    private final IdeaUseCase ideaUseCase;
    private final UserRepository userRepository;

    @Autowired
    public IdeaController(IdeaUseCase ideaUseCase, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.ideaUseCase = ideaUseCase;
    }

    @PostMapping
    public ResponseEntity<Idea> addIdea(@RequestBody Idea idea) {
        if (idea.getUserId() != null && userRepository.existsById(idea.getUserId())) {  // Fixed: Check userId not id
            Idea savedIdea = ideaUseCase.save(idea);
            userRepository.addIdeaToUser(idea.getUserId(), savedIdea.getId());
            return new ResponseEntity<>(savedIdea, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getAllIdeas() {
        List<Idea> ideas = ideaUseCase.listAllIdeas();
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Idea>> getIdeasByUser(@PathVariable String userId) {
        if (!userRepository.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Idea> ideas = ideaUseCase.findByUserId(userId);
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idea> updateIdea(@PathVariable String id, @RequestBody Idea idea) {
        idea.setId(id);
        Idea updatedIdea = ideaUseCase.update(idea);
        return new ResponseEntity<>(updatedIdea, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdea(@PathVariable String id) {
        Idea idea = ideaUseCase.findById(id);
        if (idea != null && idea.getUserId() != null) {
            userRepository.removeIdeaFromUser(idea.getUserId(), id);
        }

        ideaUseCase.deleteIdea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
