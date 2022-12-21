package br.com.dolzanes.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> listAll() {
		String jpql = "SELECT p FROM Product p";
		return em.createQuery(jpql, Product.class).getResultList();
	}
	
	public List<Product> findByName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.name = :name";
		return em.createQuery(jpql, Product.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public List<Product> findByNameForCategory(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
		return em.createQuery(jpql, Product.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public BigDecimal findPriceProductWithName(String name) {
		String jpql = "SELECT p.price FROM Products p WHERE p.name = :name";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("name", name)
				.getSingleResult();
	}
	
	public List<Product> findByNameWithCriteria(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> from = query.from(Product.class);
		
		Predicate filter = builder.and();
		
		filter = builder.and(filter, builder.equal(from.get("name"), name));
		
		query.where(filter);
		
		return em.createQuery(query).getResultList();		
	}
	
}
