package org.wcci.blog;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Author {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name = "";

	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
