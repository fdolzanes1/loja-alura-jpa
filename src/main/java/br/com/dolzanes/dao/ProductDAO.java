package br.com.dolzanes.dao;

import javax.persistence.EntityManager;

import br.com.dolzanes.model.Product;

public class ProductDAO {
	
	private EntityManager em;

	public ProductDAO(EntityManager em) {
		this.em = em;
	}
	
	public void create(Product product) {
		this.em.persist(product);
	}
	
}
