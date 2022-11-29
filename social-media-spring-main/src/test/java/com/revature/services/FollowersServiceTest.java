package com.revature.services;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Followers;
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
        User user = new User();
        user.setId(1);
        User toFollow = new User();
        toFollow.setId(2);

        Followers follow = new Followers();
        List<User> expected = new ArrayList<>();
        expected.add(toFollow);
        follow.setUser(user);
        follow.setFollowing(expected);

        //Act or When
        when(ur.findById(toFollow.getId())).thenReturn(Optional.of(toFollow));
        when(fr.save(follow)).thenReturn(follow);
        List<User> actual = fs.newFollow(user, toFollow.getId());

        //Assert or Then
        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    void testNewFollowWithEmptyFollowing() {
        //Arrange or Given
        User user = new User();
        user.setId(1);
        User toFollow = new User();
        toFollow.setId(2);

        Followers follow = new Followers();
        List<User> expected = new ArrayList<>();
        follow.setUser(user);
        follow.setFollowing(expected);


         //Act or When
         when(ur.findById(toFollow.getId())).thenReturn(Optional.of(toFollow));
         when(fr.existsByUser(user)).thenReturn(true);
         when(fr.findByUser(user)).thenReturn(follow);
         when(fr.save(follow)).thenReturn(follow);
        List<User> actual = fs.newFollow(user, toFollow.getId());

         //Assert or Then
         Assertions.assertThat(actual).contains(toFollow);
    }

    @Test
    void testNewFollowUnfollow() {
        //Arrange or Given
        User user = new User();
        user.setId(1);
        User toFollow = new User();
        toFollow.setId(2);

        Followers follow = new Followers();
        List<User> expected = new ArrayList<>();
        expected.add(toFollow);
        follow.setUser(user);
        follow.setFollowing(expected);


         //Act or When
         when(ur.findById(toFollow.getId())).thenReturn(Optional.of(toFollow));
         when(fr.existsByUser(user)).thenReturn(true);
         when(fr.findByUser(user)).thenReturn(follow);
         when(fr.save(follow)).thenReturn(follow);
         List<User> actual = fs.newFollow(user, toFollow.getId());

         //Assert or Then
         Assertions.assertThat(actual).isEmpty();
    }

}
