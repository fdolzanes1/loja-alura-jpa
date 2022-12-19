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
	
	public void update(Product product) {
		this.em.merge(product);
	}
	
	public void delete(Product product) {
		product = em.merge(product);
		this.em.remove(product);
	}
	
}
