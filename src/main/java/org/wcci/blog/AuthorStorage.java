package org.wcci.blog;

public class AuthorStorage {

	private AuthorRepository authorRepo;
	
	public void addAuthor(Author testAuthor) {
		authorRepo.save(testAuthor);		
	}

}
