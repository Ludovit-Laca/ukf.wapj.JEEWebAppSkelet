package bookstack.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

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
	
	@Transient
	private String autor;
	
	public Book() {}
	
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
