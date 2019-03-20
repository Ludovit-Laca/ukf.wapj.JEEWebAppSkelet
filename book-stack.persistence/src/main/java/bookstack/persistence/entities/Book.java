package bookstack.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBooksByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
})
public class Book implements Serializable {

	private static final long serialVersionUID = -7759431903190558099L;
	
	@Id @GeneratedValue
	private Integer idbook;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "isbn")
	private String isbn;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "author")
	private Author idauthor;

	public Author getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(Author idauthor) {
		this.idauthor = idauthor;
	}

	public Book() {}

	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	
	/*
	 * Getters and setters
	 */

	public String getTitle() {
		return title;
	}

	public Integer getIdbook() {
		return idbook;
	}

	public void setIdbook(Integer idbook) {
		this.idbook = idbook;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
