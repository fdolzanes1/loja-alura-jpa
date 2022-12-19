package br.com.dolzanes.dao;

import javax.persistence.EntityManager;

import br.com.dolzanes.model.Category;

public class CategoryDAO {
	
	private EntityManager em;

	public CategoryDAO(EntityManager em) {
		this.em = em;
	}
	
	public void create(Category category) {
		this.em.persist(category);
	}

}
