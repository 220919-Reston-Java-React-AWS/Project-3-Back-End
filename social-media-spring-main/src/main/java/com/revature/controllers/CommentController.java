package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.exceptions.NoSuchRecordException;
import com.revature.models.Comment;
import com.revature.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Comment deleteComment(@RequestBody Comment comment) {
        Comment deletedComment = new Comment();
        try {
            deletedComment = this.commentService.deleteComment(comment);

        } catch (NoSuchRecordException e) {
            e.getMessage();
        }
        return deletedComment;
    }
}
