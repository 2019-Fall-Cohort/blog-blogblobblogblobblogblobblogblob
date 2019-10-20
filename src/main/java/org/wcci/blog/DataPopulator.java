package org.wcci.blog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class DataPopulator implements CommandLineRunner {

	@Autowired
	private AuthorStorage authorStorage;
	@Autowired
	private CategoryStorage categoryStorage;
	@Autowired
	private TagStorage tagStorage;

	List<String> authors = Arrays.asList("Diana McIntosh", "Luke Brannigan");
	List<String> categories = Arrays.asList("Life", "Computer Science", "Health");
	List<String> tags = Arrays.asList("fad", "funny", "mundane", "obscure");

	@Override
	public void run(String... args) throws Exception {
		generateAuthors();
		generateCategories();
		generateTags();
	}

	private void generateTags() {
		for (String tagName : tags) {
			Tag tag = new Tag(tagName);
			tagStorage.addTag(tag);
		}
	}

	private void generateCategories() {
		for (String categoryName : categories) {
			Category category = new Category(categoryName);
			categoryStorage.addCategory(category);
		}
	}

	private void generateAuthors() {
		for (String authorName : authors) {
			Author author = new Author(authorName);
			authorStorage.addAuthor(author);
		}
	}

}
