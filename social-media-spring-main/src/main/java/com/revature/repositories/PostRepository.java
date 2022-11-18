package com.revature.repositories;

import com.revature.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
