package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryStorage {
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	public Iterable<Category> findAllCategories() {
		return categoryRepo.findAllByOrderByNameAsc();
	}

	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).get();
	}

}
