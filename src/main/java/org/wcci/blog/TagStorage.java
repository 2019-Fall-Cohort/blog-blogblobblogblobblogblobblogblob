package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagStorage {

	@Autowired
	private TagRepository tagRepo;
	
	public void addTag(Tag testTag) {
		tagRepo.save(testTag);		
	}
	
	public Iterable<Tag> findAllTags() {
		return tagRepo.findAll();
	}
	
	public void addTagToAvoidNullPointer() {
		Tag tag = new Tag("First Tag");
		addTag(tag);
	}
	
	public Tag findTagById(Long id) {
		return tagRepo.findById(id).get();
	}

}
