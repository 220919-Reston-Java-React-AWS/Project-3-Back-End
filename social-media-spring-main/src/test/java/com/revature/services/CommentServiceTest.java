package com.revature.services;

import com.revature.exceptions.NoSuchRecordException;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.CommentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentService commentService;

    private Post myPost;

    private User commenter;


    private Comment comment;

    @BeforeEach
    public void setup(){

        comment = Comment.builder()
                .id(1)
                .text("Test String")
                .commenter(commenter)
                .post(myPost)
                .build();
    }
    @Test
    public void CommentService_AddComment_ReturnAddedComment() {

        when(commentRepository.save(Mockito.any(Comment.class))).thenReturn(comment);

        Comment savedComment = commentService.addComment(comment);

        Assertions.assertThat(savedComment).isNotNull();
    }

    @Test
    void CommentService_DeleteComment_ReturnDeletedComment() throws NoSuchRecordException {

        int commentId = 1;

        willDoNothing().given(commentRepository).deleteById(commentId);


        commentService.deleteComment(comment);


        verify(commentRepository, times(1)).deleteById(commentId);
    }

//    @Test
//    void CommentService_GetAll_ReturnAllComments() {
//
//        Comment comment = Comment.builder()
//                .text("Test String")
//                .commenter(commenter)
//                .post(myPost)
//                .build();
//
//        List<Comment> mockList = new ArrayList<>();
//        Comment mockUser1 = Mockito.mock(Comment.class);
//        Comment mockUser2 = Mockito.mock(Comment.class);
//
//        mockList.add(mockUser1);
//        mockList.add(mockUser2);
//
//        when(commentRepository.findAll(Mockito.any(comment))).thenReturn(mockList);
//
//        //Assert
//        Assertions.assertThat(comment).isNotNull();
//        Assertions.assertThat(comment.getId()).isEqualTo(2);
//
//    }
}
