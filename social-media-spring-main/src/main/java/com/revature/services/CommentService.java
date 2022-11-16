package com.revature.services;

import com.revature.models.Comment;
import com.revature.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepository;
    public Optional<Comment> deleteComment(Comment comment) {
        Optional<Comment> deletedComment = this.commentRepository.findById(comment.getId());

        this.commentRepository.delete(comment);

        return deletedComment;
    }
}
