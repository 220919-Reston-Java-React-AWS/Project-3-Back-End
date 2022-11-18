package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    public CommentService commentService;

    @Authorized
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(this.commentService.getAll());
    }

    @Authorized
    @PutMapping
    public Comment addComment(Comment comment) {
        return commentService.addComment(comment);
    }

    @Authorized
    @DeleteMapping("/delete-comment")
    public Optional<Comment> deleteComment(@RequestBody Comment comment, Post post) {
        return this.commentService.deleteComment(comment, post);}
}
