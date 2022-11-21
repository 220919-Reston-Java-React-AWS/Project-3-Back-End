package com.revature.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.PostService;

@WebMvcTest(controllers = PostController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddOrRemoveLike() {

    }

    @Test
    void testDeletePost() {

    }

    @Test
    void testGetAllPosts() {

    }

    @Test
    void testUpsertPost() {

    }
}
