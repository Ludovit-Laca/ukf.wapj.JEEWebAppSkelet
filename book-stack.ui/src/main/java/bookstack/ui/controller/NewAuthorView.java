package bookstack.ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import bookstack.persistence.entities.Author;

@Named
public class NewAuthorView implements Serializable {

	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		author = new Author();
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}
	
}
