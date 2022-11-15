package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    public CommentService commentService;

    @Authorized
    @DeleteMapping("/delete-comment")
    public Optional<Comment> deleteComment(@RequestBody Comment comment) {
        return this.commentService.deleteComment(comment);}
}
