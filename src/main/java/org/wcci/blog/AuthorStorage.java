package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorStorage {

	@Autowired
	private AuthorRepository authorRepo;
	
	public void addAuthor(Author testAuthor) {
		authorRepo.save(testAuthor);		
	}
	
	public Iterable<Author> findAllAuthors() {
		return authorRepo.findAllByOrderByNameAsc();
	}
	
	public void addAuthorToAvoidNullPointer() {
		Author author = new Author("First Author");
		addAuthor(author);
	}
	
	public Author findAuthorById(Long id) {
		return authorRepo.findById(id).get();
	}

}
