package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.CategoryDAO;
import bookstack.persistence.entities.Category;

@Stateless
public class CategoryService {

	@Inject
	private CategoryDAO categoryDao;

	public List<Category> getAllCategories() {
		return this.categoryDao.findAll();
	}

	public Category getCategoryByName(String name) {
		return this.categoryDao.getCategoryByName(name);
	}

	public Category createCategory(Category category) {
		return this.categoryDao.create(category);
	}
}
