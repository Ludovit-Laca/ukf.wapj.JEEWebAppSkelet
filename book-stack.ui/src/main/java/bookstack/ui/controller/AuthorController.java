package bookstack.ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.AuthorService;
import bookstack.persistence.entities.Author;

@Named
@RequestScoped
public class AuthorController implements Serializable {

	private static final long serialVersionUID = -2129165097459455893L;

	@Inject
	private AuthorsView authorsView;
	
	@Inject
	private AuthorService authorService;
	
	@PostConstruct
	private void init(){
		System.out.println(this.getClass().getName() + " was created.");

	}
	
	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}

	public void createAuthor() {
		Author author = authorService.createAuthor(authorsView.getAuthor());
		System.out.println(author);
		authorsView.setAuthor(new Author());
		authorsView.setAuthorList(authorService.getAllAuthors());
	}
	
}
