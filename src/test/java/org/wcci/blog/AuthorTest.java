package org.wcci.blog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuthorTest {

	@Test
	public void canCreateAuthor() {
		Author underTest = new Author("Test Author");
		String expected = underTest.getName();
		assertEquals(expected, "Test Author");
	}
	
}
