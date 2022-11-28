package com.revature.services;

import com.revature.exceptions.NoSuchRecordException;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import org.aspectj.lang.annotation.Before;
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
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;
    private Post post;
    private User user;

    @BeforeEach
    public void setUp(){
        user = User.builder()
            .id(1)
            .email("testemail@gmail.com")
            .password("password")
            .firstName("John")
            .lastName("Doe")
            .username("JD")
            .build();
    }

    @BeforeEach
    public void setup() {

        post = Post.builder()
                .postId(1)
                .text("Test String")
                .author(user)
                .build();
    }

    @Test
    public void PostService_UpsertPost_ReturnUpsertPost() {

        when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);

        Post savedPost = postService.upsert(post);

        Assertions.assertThat(savedPost).isNotNull();
    }

    @Test
    void PostService_DeletePost_ReturnDeletedPost() {

        int postId = 1;

        willDoNothing().given(postRepository).delete(post);


        postService.deletePost(post);


        verify(postRepository, times(1)).delete(post);
    }

    @Test
    void PostService_GetAll_ReturnAllPosts() {

        Post post1 = Post.builder()
                .postId(1)
                .text("Test String")
                .author(user)
                .build();

        List<Post> listPost = new ArrayList<>();

        when(postRepository.findAllByAuthor(Mockito.eq(user))).thenReturn(listPost);

        given(postRepository.findAll()).willReturn(List.of(post, post1));

        List<Post> postList = postService.getAll(user);

        Assertions.assertThat(postList).isNotNull();
        Assertions.assertThat(postList.size()).isEqualTo(2);
    }
}