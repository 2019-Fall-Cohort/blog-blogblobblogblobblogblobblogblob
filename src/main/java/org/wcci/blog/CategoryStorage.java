package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryStorage {
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	public Iterable<Category> findAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}
