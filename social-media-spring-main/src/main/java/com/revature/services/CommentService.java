package com.revature.services;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.CommentRepository;
import com.revature.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    public PostRepository postRepository;

    public List<Comment> getAll() {
        return this.commentRepository.findAll();
    }
    public Optional<Comment> deleteComment(Comment comment, Post post) {
        List<Comment> comments = post.getComments();

        comments.remove(comment);

        this.postRepository.save(post);


        Optional<Comment> deletedComment = this.commentRepository.findById(comment.getId());

        this.commentRepository.delete(comment);

        return deletedComment;
    }
}
