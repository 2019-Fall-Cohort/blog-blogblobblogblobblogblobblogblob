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
	@Autowired
	private AuthorStorage authorStorage;
	@Autowired
	private CategoryStorage categoryStorage;

	@GetMapping("/posts")
	public String preparePostView(Model model) {
		Iterable<Post> retrievedPosts = postStorage.findAllPosts();
		model.addAttribute("posts", retrievedPosts);

		Iterable<Author> retrievedAuthors = authorStorage.findAllAuthors();
		model.addAttribute("authors", retrievedAuthors);
		
		Iterable<Category> retrievedCategories = categoryStorage.findAllCategories();
		model.addAttribute("categories", retrievedCategories);
		
		return "posts";
	}

	@PostMapping("/createPost")
	public String createPost(String title, String text, Long authorId, Long categoryId) {
		
		Category category = categoryStorage.findCategoryById(categoryId);
		Author author = authorStorage.findAuthorById(authorId);
		
		Post post = new Post(title, text, author, category);
		postStorage.addPost(post);
		
		return "redirect:/posts";
	}

}
