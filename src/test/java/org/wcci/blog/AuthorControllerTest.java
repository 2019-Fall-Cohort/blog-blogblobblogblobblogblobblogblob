package org.wcci.blog;

import java.util.Collections;


import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

public class AuthorControllerTest {
	@InjectMocks
	private AuthorController underTest;
	@Mock
	AuthorStorage mockStorage;
	@Mock
	private Model mockModel;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void shouldAddAuthorsToModel() {
	Author mockAuthor = mock(Author.class);
	when(mockStorage.findAllAuthors()).thenReturn(Collections.singleton(mockAuthor));
	underTest.prepareAuthorView(mockModel);
	verify(mockModel).addAttribute("authors", Collections.singleton(mockAuthor));
	
	}

}
