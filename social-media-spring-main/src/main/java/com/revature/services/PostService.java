package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Followers;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.FollowersRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Autowired
	private FollowersRepository fr;

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	// public List<Post> getAll(User user) {
	// 	if (fr.existsByUser(user)) {
	// 	Followers followTable = fr.findByUser(user);
	// 	List<User> following = followTable.getFollowing();
	// 	for (iterable_type iterable_element : iterable) {
			
	// 	}

	// 	return posts;
	// 	} else {
	// 		Followers follow = new Followers();
    //         List<User> following = new ArrayList<>();

    //         follow.setUser(user);
	// 		follow.setFollowing(following);
	// 		return ur.findByUser(following.get(1));
	// 	}
		
	// }

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
