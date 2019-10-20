package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Post> posts;

	public Category(String name) {
		this.name = name;
	}
	
	protected Category() {}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}

	public Long getId() {
		return id;
	}
	
}
