package bookstack.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bookstack.persistence.dao.AuthorDAO;
import bookstack.persistence.entities.Author;

@Stateless
public class AuthorService {

	@Inject
	private AuthorDAO authorDAO;
	
	public Author findAuthorByName(String name,String surname){
		return this.authorDAO.getAuthorByName(name, surname);
	}
	
	public Author createAuthor(Author author) {
		return this.authorDAO.create(author);
	}
	
	public List<Author> getAllAuthors() {
		return this.authorDAO.findAll();
	}
	
	// Nie úplne korektné riešenie, ale funguje :)
	public String getAllAuthorsJson() {
		List<Author> authors = getAllAuthors();
		JsonArray arr = new JsonArray();
		for (Author author : authors) {
			JsonObject riadok = new JsonObject();
			riadok.addProperty("x", author.getFullName());
			riadok.addProperty("y", String.valueOf(author.getBooks().size()));
			arr.add(riadok);
		}
		return new Gson().toJson(arr);
	}
}