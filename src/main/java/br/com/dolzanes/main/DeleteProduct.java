package br.com.dolzanes.main;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.ProductDAO;
import br.com.dolzanes.model.Product;
import br.com.dolzanes.util.JPAUtil;

public class DeleteProduct {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDAO productDao = new ProductDAO(entityManager);
		Product smartphone = entityManager.find(Product.class, 2L);
		
		productDao.delete(smartphone);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();	
	}

}
