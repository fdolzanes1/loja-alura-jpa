package br.com.dolzanes.dao;

import javax.persistence.EntityManager;

import br.com.dolzanes.model.Category;
import br.com.dolzanes.model.Product;

public class CategoryDAO {
	
	private EntityManager em;

	public CategoryDAO(EntityManager em) {
		this.em = em;
	}
	
	public void create(Category category) {
		this.em.persist(category);
	}
	
	public void update(Category category) {
		this.em.merge(category);
	}
	
	public void delete(Category category) {
		category = em.merge(category);
		this.em.remove(category);
	}

}
