package bookstack.ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.AuthorService;
import bookstack.persistence.entities.Author;

@ViewScoped
@Named
public class AuthorsView implements Serializable {

	private static final long serialVersionUID = 7253943731039849041L;
	
	private Author author;
	private List<Author> authorList;
	
	@Inject
	private AuthorService authorService;

	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		author = new Author();
		authorList = authorService.getAllAuthors();
	}

	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	
}
