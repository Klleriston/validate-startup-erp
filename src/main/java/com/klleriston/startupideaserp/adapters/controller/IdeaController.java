package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.IdeaUseCase;
import com.klleriston.startupideaserp.domain.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idea")
public class IdeaController {
    private final IdeaUseCase ideaUseCase;

    @Autowired
    public IdeaController(IdeaUseCase ideaUseCase) {
        this.ideaUseCase = ideaUseCase;
    }

    @PostMapping
    public ResponseEntity<Idea> addIdea(@RequestBody Idea idea) {
        Idea savedIdea = ideaUseCase.save(idea);
        return new ResponseEntity<>(savedIdea, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getAllIdeas() {
        List<Idea> ideas = ideaUseCase.listAllIdeas();
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idea> updateIdea(@PathVariable String id, @RequestBody Idea idea) {
        idea.setId(id);
        Idea updatedIdea = ideaUseCase.update(idea);
        return new ResponseEntity<>(updatedIdea, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Idea> deleteIdea(@PathVariable String id,@RequestBody Idea idea) {
        ideaUseCase.deleteIdea(id);
        return new ResponseEntity<>(idea, HttpStatus.NO_CONTENT);
    }
}
