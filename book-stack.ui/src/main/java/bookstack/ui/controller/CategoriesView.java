package bookstack.ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.CategoryService;
import bookstack.persistence.entities.Category;

@ViewScoped
@Named
public class CategoriesView implements Serializable {

	private static final long serialVersionUID = -2316850523015138437L;
	
	private Category category;
	private List<Category> categoryList;
	
	private String graphData;
	
	@Inject
	private CategoryService categoryService;
	
	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		categoryList = categoryService.getAllCategories();
		category = new Category();
		graphData = categoryService.getCountOfBooksInCategories();
	}

	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getGraphData() {
		return graphData;
	}

	public void setGraphData(String graphData) {
		this.graphData = graphData;
	}

	
}
