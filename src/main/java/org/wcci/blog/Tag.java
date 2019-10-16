package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "tags")
	private List<Post> posts;

	public Tag(String name) {
		this.name = name;
	}

	protected Tag() {
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}

}
