package bookstack.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import bookstack.persistence.entities.Category;

@Stateless
public class CategoryDAO extends AbstractDAO<Category> {

	public CategoryDAO() {
		super(Category.class);
	}

	public Category getCategoryByName(String name) {
		TypedQuery<Category> query = em.createNamedQuery("findCategoryByName", Category.class);
		query.setParameter("name", name);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
