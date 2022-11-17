package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserIdFollow;
import com.revature.models.Followers;
import com.revature.models.User;
import com.revature.repositories.FollowersRepository;
import com.revature.repositories.UserRepository;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository fr;

    @Autowired
    private UserRepository ur;

    public List<User> newFollow(User user, UserIdFollow userId) {

        Optional<User> toFollow = ur.findById(userId.getId());
        Followers following = fr.findByUser(user);

        if (!following.getFollowing().contains(toFollow.get())) {
            following.getFollowing().add(toFollow.get());
        } else {
            following.getFollowing().remove(toFollow.get());
        }

        fr.save(following);
        return following.getFollowing();
    }
    
}
