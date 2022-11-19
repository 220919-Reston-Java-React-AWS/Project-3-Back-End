package com.revature.services;

import com.revature.exceptions.NoSuchRecordException;
import com.revature.models.Comment;
import com.revature.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepository;

    public List<Comment> getAll() {
        return this.commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment deleteComment(Comment comment) throws NoSuchRecordException {
        Optional<Comment> deletedComment = this.commentRepository.findById(comment.getId());
        if (!deletedComment.isEmpty()) {
            Comment deleted = deletedComment.get();
            System.out.println("id:-------------" + comment.getId()
                    + "----------------------------------------------------------------");
            this.commentRepository.deleteById(comment.getId());
            return deleted;
        } else {
            throw new NoSuchRecordException("Comment not found");
        }
    }
}
