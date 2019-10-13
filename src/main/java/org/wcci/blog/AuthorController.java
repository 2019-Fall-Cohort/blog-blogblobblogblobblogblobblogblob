package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
	
	private AuthorStorage authorStorage;
	
	@GetMapping("/authors")
	public String prepareAuthorView(Model model) {
//		authorStorage.addAuthorToAvoidNullPointer();
		Iterable<Author> retrievedAuthors = authorStorage.findAllAuthors();
		model.addAttribute("authors", retrievedAuthors);
		return "authors";
	}

}
