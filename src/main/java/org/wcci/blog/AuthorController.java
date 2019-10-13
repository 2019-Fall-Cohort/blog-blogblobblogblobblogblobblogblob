package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorStorage authorStorage;
	
	@GetMapping("/authors")
	public String prepareAuthorView(Model model) {
		Iterable<Author> retrievedAuthors = authorStorage.findAllAuthors();
		model.addAttribute("authors", retrievedAuthors);
		return "authors";
	}
	
	@PostMapping("/createAuthor")
	public String createAuthor(String name) {
		Author author = new Author(name);
		authorStorage.addAuthor(author);
		return "redirect:/authors";
		
	}
	

}
