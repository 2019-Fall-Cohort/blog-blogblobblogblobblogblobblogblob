package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryStorage categoryStorage;
	
	@GetMapping("/categories")
	public String prepareCategoryView(Model model) {
		Iterable<Category> retrievedCategories = categoryStorage.findAllCategories();
		model.addAttribute("categories", retrievedCategories);
		return "categories";
	}

}
