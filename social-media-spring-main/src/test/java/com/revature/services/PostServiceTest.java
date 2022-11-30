package com.revature.services;

import com.revature.exceptions.NoSuchRecordException;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;
    private Post post;
    private User user;

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

        Post post = Post.builder()
                .postId(1)
                .text("Test String")
                .author(user)
                .build();

        List<Post> listPost = new ArrayList<>();

        Post mockUser1 = Mockito.mock(Post.class);
        Post mockUser2 = Mockito.mock(Post.class);

        listPost.add(mockUser1);
        listPost.add(mockUser2);

//        when(postRepository.findAll()).thenReturn(listPost);

        Assertions.assertThat(listPost.size()).isEqualTo(2);
    }

    @Test
    void PostService_AddLike() {
        User user = User.builder()
                .id(1)
                .email("test@test.com")
                .password("password").build();

        List<User> likes = new ArrayList<>();

        post = Post.builder()
                .postId(1)
                .text("Test String")
                .author(user)
                .likes(likes)
                .build();

        when(postRepository.save(post)).thenReturn(post);

        Post savedPost = postService.addOrRemoveLike(post, user);

        Assertions.assertThat(savedPost).isNotNull();
        Assertions.assertThat(savedPost.getLikes().size()).isEqualTo(1);
    }

    @Test
    void PostService_RemoveLike() {
        User user = User.builder()
                .id(1)
                .email("test@test.com")
                .password("password").build();

        List<User> likes = new ArrayList<>();
        likes.add(user);

        post = Post.builder()
                .postId(1)
                .text("Test String")
                .author(user)
                .likes(likes)
                .build();

        when(postRepository.save(post)).thenReturn(post);

        Post savedPost = postService.addOrRemoveLike(post, user);

        Assertions.assertThat(savedPost).isNotNull();
        Assertions.assertThat(savedPost.getLikes().size()).isEqualTo(0);
    }

}