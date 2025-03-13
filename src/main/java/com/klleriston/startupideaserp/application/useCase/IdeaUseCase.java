package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Idea;
import com.klleriston.startupideaserp.infra.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaUseCase {
    private final IdeaRepository ideaRepository;

    @Autowired
    public IdeaUseCase(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public Idea save(Idea idea) {
        return ideaRepository.save(idea);
    }

    public List<Idea> listAllIdeas() {
        return ideaRepository.findAll();
    }

    public List<Idea> findByUserId(String userId) {
        return ideaRepository.findByUserId(userId);
    }

    public Idea findById(String id) {
        return ideaRepository.findById(id).orElse(null);
    }

    public Idea update(Idea idea) {
        Idea existingIdea = ideaRepository.findById(idea.getId())
                .orElseThrow(() -> new IllegalArgumentException("Idea with id " + idea.getId() + " not found"));

        existingIdea.setTitle(idea.getTitle());
        existingIdea.setDescription(idea.getDescription());
        existingIdea.setCategory(idea.getCategory());
        existingIdea.setStatus(idea.getStatus());

        return ideaRepository.save(existingIdea);
    }

    public void deleteIdea(String id) {
        ideaRepository.deleteById(id);
    }
}