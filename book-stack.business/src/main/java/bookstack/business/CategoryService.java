package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
	
	public String getCountOfBooksInCategories() {
		List<Category> categories = getAllCategories();
		JsonArray arr = new JsonArray();
		for (Category cat : categories) {
			JsonObject riadok = new JsonObject();
			riadok.addProperty("label", cat.getCategory());
			riadok.addProperty("value", String.valueOf(cat.getBooks().size()));
			arr.add(riadok);
		}
		return new Gson().toJson(arr);
	}
}
