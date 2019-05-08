package bookstack.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "findCategoryByName", query = "SELECT c FROM Category c WHERE c.category LIKE :name")
})
public class Category {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String category;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Book> books;
	
	public Category() {
	}

	public Category(int id, String category) {
		super();
		this.id = id;
		this.category = category;
		this.books = new ArrayList<>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
