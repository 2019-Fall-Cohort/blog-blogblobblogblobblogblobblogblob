package org.wcci.blog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import org.junit.Before;
import org.junit.Test;

public class AuthorStorageTest {
	

	@Test
	public void canAddAuthorToStorage() {
		AuthorStorage underTest = new AuthorStorage();
		Author testAuthor = new Author("Test Author");
		
		underTest.addAuthor(testAuthor);
		assertThat(underTest.findAllAuthors(), hasItem(testAuthor));

	}
	
}
