package org.wcci.blog;

import org.junit.Test;

public class AuthorStorageTest {

	@Test
	public void canAddAuthorToStorage() {
		AuthorStorage underTest = new AuthorStorage();
		Author testAuthor = new Author("Test Author");
		
		underTest.addAuthor(testAuthor);
		
		
		
		
	}
	
}
