package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStorage {

	@Autowired
	private PostRepository postRepo;
	
	public void addPost(Post testPost) {
		postRepo.save(testPost);		
	}
	
	public Iterable<Post> findAllPosts() {
		return postRepo.findAll();
	}
	
}