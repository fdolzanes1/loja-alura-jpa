package br.com.dolzanes.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.ProductDAO;
import br.com.dolzanes.model.Product;
import br.com.dolzanes.util.JPAUtil;

public class FindProductByNameWithCriteria {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDAO productDao = new ProductDAO(entityManager);
		
		List<Product> products = productDao.findByNameWithCriteria("Motorola EDGE");
		
		products.forEach(product -> System.out.println(product.getId()+" "+product.getName()));
	}

}
