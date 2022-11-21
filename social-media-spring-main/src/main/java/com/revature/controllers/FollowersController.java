package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.dtos.UserToFollow;
import com.revature.models.Followers;
import com.revature.models.User;
import com.revature.services.FollowersService;
import com.revature.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class FollowersController {

    @Autowired
    private FollowersService fs;

    @Autowired
    private UserService us;

    @Authorized
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(us.getAllUsers());
    }

    // @Authorized
    // @PutMapping("/follow")
    // public ResponseEntity<List<User>> newFollow(@RequestBody UserIdFollow userId, HttpSession session) {

    //     User user = (User) session.getAttribute("user");
    //     int id = userId.getUserId();

    //     return ResponseEntity.ok(fs.newFollow(user, id));
    // }

    // To test with swagger if response body is correct
    //new comment
    @Authorized
    @PutMapping("/follow")
    public ResponseEntity<UserToFollow> newFollow (HttpSession session, @RequestBody UserToFollow userId) {
        System.out.println(userId);
        return ResponseEntity.ok(userId);
    }
    
}
