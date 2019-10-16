package org.wcci.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStorage {

	@Autowired
	private PostRepository postRepo;
	
	public void addPost(Post post) {
		postRepo.save(post);		
	}
	
	public Iterable<Post> findAllPosts() {
		return postRepo.findAll();
	}

	public void addTagsToPost(Post post, List<Tag> tags) {
		post.addTags(tags);
		postRepo.save(post);
	}
	
}