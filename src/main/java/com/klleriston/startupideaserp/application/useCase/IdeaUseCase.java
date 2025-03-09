package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.Idea;
import com.klleriston.startupideaserp.infra.repository.IdeaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaUseCase {
    private final IdeaRepositoryImpl ideaRepositoryImpl;

    @Autowired
    public IdeaUseCase(IdeaRepositoryImpl ideaRepositoryImpl) {
        this.ideaRepositoryImpl = ideaRepositoryImpl;
    }

    public Idea save(Idea idea) {
        return ideaRepositoryImpl.save(idea);
    }

    public List<Idea> listAllIdeas() {
        return ideaRepositoryImpl.findAll();
    }

    public Idea update(Idea idea) {
        Idea existingIdea = ideaRepositoryImpl.findById(idea.getId()).orElseThrow(() -> new IllegalArgumentException("Idea with id " + idea.getId() + " not found"));

        existingIdea.setTitle(idea.getTitle());
        existingIdea.setDescription(idea.getDescription());
        existingIdea.setCategory(idea.getCategory());
        existingIdea.setStatus(idea.getStatus());

        return ideaRepositoryImpl.save(existingIdea);
    }

    public void deleteIdea(String id) {
        ideaRepositoryImpl.deleteById(id);
    }
}
