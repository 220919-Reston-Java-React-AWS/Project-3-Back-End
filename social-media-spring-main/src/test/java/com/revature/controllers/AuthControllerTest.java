package com.revature.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.services.AuthService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AuthController.class)
@RequestMapping("/auth")
public class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    // @Test
    // public void testLogin() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.post("/login"))
    //             .andExpect(MockMvcResultMatchers.status().isOk());
    // }

    // @Test
    // void testLogout() {

    // }

    // @Test
    // void testRegister() {

    // }
}
