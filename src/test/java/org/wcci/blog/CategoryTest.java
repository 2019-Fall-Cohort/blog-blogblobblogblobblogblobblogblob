package org.wcci.blog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CategoryTest {
	
	@Test
	public void canCreateCategory() {
		Category underTest = new Category("Test Category");
		String expected = underTest.getName();
		assertEquals(expected, "Test Category");
	}

}
