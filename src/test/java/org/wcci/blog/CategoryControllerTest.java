package org.wcci.blog;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

public class CategoryControllerTest {
	
	@InjectMocks
	private CategoryController underTest;
	@Mock
	CategoryStorage mockStorage;
	@Mock
	private Model mockModel;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void shouldAddCategoriesToModel() {
	Category mockCategory = mock(Category.class);
	when(mockStorage.findAllCategories()).thenReturn(Collections.singleton(mockCategory));
	underTest.prepareCategoryView(mockModel);
	verify(mockModel).addAttribute("categories", Collections.singleton(mockCategory));
	
	}


}
