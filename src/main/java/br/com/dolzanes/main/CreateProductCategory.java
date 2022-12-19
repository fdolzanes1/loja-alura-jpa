package br.com.dolzanes.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.CategoryDAO;
import br.com.dolzanes.dao.ProductDAO;
import br.com.dolzanes.model.Category;
import br.com.dolzanes.model.Product;
import br.com.dolzanes.util.JPAUtil;

public class CreateProductCategory {

	public static void main(String[] args) {
		
		Category category = new Category("Smartphone");
		Product smartphone = new Product("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), category);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProductDAO productDao = new ProductDAO(entityManager);
		CategoryDAO categoryDao = new CategoryDAO(entityManager);
		
		categoryDao.create(category);
		productDao.create(smartphone);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}
