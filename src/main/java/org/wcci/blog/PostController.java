package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
	
	@Autowired
	private PostStorage postStorage;
	
	@GetMapping("/posts")
	public String preparePostView(Model model) {
		Iterable<Post> retrievedPosts = postStorage.findAllPosts();
		model.addAttribute("posts", retrievedPosts);
		return "posts";
	}
	
//	@PostMapping("/createPost")
//	public String createPost(String title, String text, Author author, Long categoryID) {
//		Category category = 
//		Post post = new Post(title, text, author, category);
//		postStorage.addPost(post);
//		return "redirect:/posts";
//		
//	}
	

}
