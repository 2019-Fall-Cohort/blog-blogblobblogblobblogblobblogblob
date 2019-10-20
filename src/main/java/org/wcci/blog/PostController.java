package org.wcci.blog;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	private TagStorage tagStorage;

	@GetMapping("/posts")
	public String preparePostView(Model model) {
		Iterable<Post> retrievedPosts = postStorage.findAllPosts();
		model.addAttribute("posts", retrievedPosts);

		Iterable<Author> retrievedAuthors = authorStorage.findAllAuthors();
		model.addAttribute("authors", retrievedAuthors);

		Iterable<Category> retrievedCategories = categoryStorage.findAllCategories();
		model.addAttribute("categories", retrievedCategories);

		Iterable<Tag> retrievedTags = tagStorage.findAllTags();
		model.addAttribute("tags", retrievedTags);

		return "posts";
	}

	@PostMapping("/createPost")
	public String createPost(String title, String text, Long authorId, Long categoryId, Long... tagId) {

		Category category = categoryStorage.findCategoryById(categoryId);
		Author author = authorStorage.findAuthorById(authorId);

		Post post = new Post(title, text, author, category);
		postStorage.addPost(post);

		if (tagId != null) {
			List<Tag> tags = new ArrayList<Tag>();
			for (Long id : tagId) {
				tags.add(tagStorage.findTagById(id));
			}
			postStorage.addTagsToPost(post, tags);
		}

		return "redirect:/posts";
	}

}
