package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.VotesUseCase;
import com.klleriston.startupideaserp.domain.model.Votes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    private final VotesUseCase votesUseCase;

    @Autowired
    public VoteController(VotesUseCase votesUseCase) {
        this.votesUseCase = votesUseCase;
    }

    @PostMapping
    public ResponseEntity<Votes> addVote(@RequestBody Votes votes) {
        Votes postVote = votesUseCase.save(votes);
        return new ResponseEntity<>(postVote, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Votes>> getVotes() {
        List<Votes> votes = votesUseCase.findAllVotes();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Votes> updateVote(@PathVariable String id, @RequestBody Votes votes) {
        votes.setId(id);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Votes> deleteVote(@PathVariable String id, @RequestBody Votes votes) {
        votesUseCase.deleteVote(id);
        return new ResponseEntity<>(votes, HttpStatus.NO_CONTENT);
    }
}
