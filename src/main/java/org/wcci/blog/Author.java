package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	public Author(String name) {
		this.name = name;
	}
	
	protected Author() {}

	public String getName() {
		return name;
	}
	
}
