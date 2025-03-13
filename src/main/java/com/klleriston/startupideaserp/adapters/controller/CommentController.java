package com.klleriston.startupideaserp.adapters.controller;

import com.klleriston.startupideaserp.application.useCase.CommentsUseCase;
import com.klleriston.startupideaserp.domain.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentsUseCase commentsUseCase;

    @Autowired
    public CommentController(CommentsUseCase commentsUseCase) {
        this.commentsUseCase = commentsUseCase;
    }

    @PostMapping
    public ResponseEntity<Comments> addComment(@RequestBody Comments comments) {
        Comments postComment = commentsUseCase.save(comments);
        return new ResponseEntity<>(postComment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comments>> findAllComments() {
        List<Comments> comments = commentsUseCase.FindAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable String id, @RequestBody Comments comments) {
        comments.setId(id);
        Comments editComment = commentsUseCase.update(comments);
        return new ResponseEntity<>(editComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentsUseCase.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
