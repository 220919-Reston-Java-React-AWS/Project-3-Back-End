package com.revature.services;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    void testFindByCredentials() {

    }

    @Test
    void testGetAllUsers() {

    }

    @Test
    void testGetProfileInfo() {

    }

    @Test
    void testSave() {
        User user = User.builder()
                .email("test@test.com")
                .password("password").build();

        when(userService.save(Mockito.any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        Assertions.assertThat(savedUser).isNotNull();
    }

    @Test
    void testUpdateProfileInfo() {

    }
}