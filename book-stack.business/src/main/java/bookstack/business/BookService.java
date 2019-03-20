package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.BookDAO;
import bookstack.persistence.entities.Book;

@Stateless
public class BookService {
	
	@Inject
	private BookDAO bookDao;
	
	public List<Book> getBooksByTitle(String title) {
		return bookDao.getBooksByTitle(title);
	}
	
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	public void createNewBook() {
		Book kniha = new Book();
		kniha.setTitle("example");
		kniha.setAutor("autor");
		kniha.setIsbn("isbn");
		kniha.setIdauthor(1);
		bookDao.create(kniha);
	}
	
}
