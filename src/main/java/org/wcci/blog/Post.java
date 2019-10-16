package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private String title;
	@ManyToOne
	private Author author;
	@ManyToOne
	private Category category;
	
	public Post(String title, String text, Author author, Category category) {
		this.title = title;
		this.text = text;
		this.author = author;
		this.category = category;
	}
	
	protected Post() {}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", title=" + title + ", author=" + author + ", category="
				+ category + "]";
	}


	
}
