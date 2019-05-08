package bookstack.ui.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.CategoryService;
import bookstack.persistence.entities.Category;

@Named
@RequestScoped
public class CategoryController implements Serializable {

	private static final long serialVersionUID = -4404178532213050845L;

	@Inject
	private CategoryService categoryService;
	
	@Inject
	private CategoriesView categoriesView;
	
	@PostConstruct
	private void init(){
		System.out.println(this.getClass().getName() + " was created.");

	}
	
	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}
	
	public void createCategory(){
		Category category = categoriesView.getCategory();
		try {
			System.out.println(new String(category.getCategory().getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoryService.createCategory(category);
		
		//refresh data na UI
		categoriesView.setCategoryList(categoryService.getAllCategories());
		categoriesView.setCategory(new Category());
		categoriesView.setGraphData(categoryService.getCountOfBooksInCategories());
	}
}
