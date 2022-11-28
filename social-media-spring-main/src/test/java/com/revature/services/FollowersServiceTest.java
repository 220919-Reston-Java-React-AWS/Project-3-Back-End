package com.revature.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.User;
import com.revature.repositories.FollowersRepository;
import com.revature.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class FollowersServiceTest {
    @Mock
    private FollowersRepository fr;

    @Mock
    private UserRepository ur;

    @InjectMocks
    private FollowersService fs;

    @Test
    void testNewFollowWithNoFollowing() {

        //Arrange or Given
        User user = User.builder().id(1).build();
        User user1 = User.builder().id(2).build();

        List<User> expected = new ArrayList<>();
        expected.add(user1);

        //Act or When
        when(ur.findById(user1.getId())).thenReturn(Optional.of(user1));
        when(fs.newFollow(user, user1.getId())).thenReturn(expected);
        
        //Assert or Then
        List<User> actual = fs.newFollow(user, user1.getId());

        Assertions.assertEquals(expected, actual);
    }

}
