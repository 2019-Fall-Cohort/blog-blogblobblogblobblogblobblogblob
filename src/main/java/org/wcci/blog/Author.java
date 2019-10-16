package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<Post> posts;

	public Author(String name) {
		this.name = name;
	}
	
	protected Author() {}

	public String getName() {
		return name;
	}
	
	

	public Long getId() {
		return id;
	}

	public List<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
	
}
