package bookstack.ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.AuthorService;
import bookstack.business.BookService;
import bookstack.business.CategoryService;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Book;
import bookstack.persistence.entities.Category;

@ViewScoped
@Named
public class BooksView implements Serializable {
	
	private static final long serialVersionUID = 6559129950166292602L;
	
	private Author author;
	private Book book;
	private List<Book> bookList;
	private List<Author> authorList;
	private List<Category> categoryList;
	private Author selectedAuthor;
	private Category selectedCategory;

	@Inject
	private BookService bookService;
	
	@Inject
	private AuthorService authorService;
	
	@Inject
	private CategoryService categoryService;
	
	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		bookList = bookService.getAllBooks();
		authorList = authorService.getAllAuthors();
		categoryList = categoryService.getAllCategories();
		author = new Author();
		book = new Book();
		System.out.println(authorService.getAllAuthorsJson());
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Author getSelectedAuthor() {
		return selectedAuthor;
	}

	public void setSelectedAuthor(Author selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	
	

}