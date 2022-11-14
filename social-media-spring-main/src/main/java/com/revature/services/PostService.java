package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public Optional<Post> deletePost(Post post) {
		Optional<Post> deletedPost = this.postRepository.findById(post.getId());

		this.postRepository.delete(post);

		return deletedPost;

	}

	public Post addOrRemoveLike(Post post, User user) {
		List<User> likes = post.getLikes();
		if (likes.contains(user)) {
			likes.remove(user);
		} else {
			likes.add(user);
		}
		post.setLikes(likes);
		this.postRepository.save(post);
		return post;
	}
}
