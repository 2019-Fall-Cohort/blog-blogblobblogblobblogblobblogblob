package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {
	
	@Autowired
	private TagStorage tagStorage;
	
	@GetMapping("/tags")
	public String prepareTagView(Model model) {
		Iterable<Tag> retrievedTags = tagStorage.findAllTags();
		model.addAttribute("tags", retrievedTags);
		return "tags";
	}
	
	@PostMapping("/createTag")
	public String createTag(String name) {
		Tag tag = new Tag(name);
		tagStorage.addTag(tag);
		return "redirect:/tags";
		
	}
	

}
