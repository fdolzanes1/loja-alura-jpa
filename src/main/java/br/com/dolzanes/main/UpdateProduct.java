package br.com.dolzanes.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.CategoryDAO;
import br.com.dolzanes.dao.ProductDAO;
import br.com.dolzanes.model.Product;
import br.com.dolzanes.util.JPAUtil;

public class UpdateProduct {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProductDAO productDao = new ProductDAO(entityManager);
		
		Product smartphone = new Product();
		smartphone.setId(2L);
		smartphone.setName("Motorola EDGE");
		smartphone.setDescription("32GB 100mp");
		smartphone.setPrice(2000.0);
		
		productDao.update(smartphone);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
