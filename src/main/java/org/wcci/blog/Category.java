package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	private String name;
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Category(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

}
