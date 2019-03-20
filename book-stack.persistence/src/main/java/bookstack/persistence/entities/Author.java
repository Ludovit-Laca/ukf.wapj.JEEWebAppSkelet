package bookstack.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "firstname")
	private String name;
	
	@Column(name = "lastname")
	private String surname;
	
	@OneToMany(mappedBy = "idauthor")
	private List<Book> books;

	public Author() {
	}

	public Author(String name, String surname, List<Book> books) {
		this.name = name;
		this.surname = surname;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
