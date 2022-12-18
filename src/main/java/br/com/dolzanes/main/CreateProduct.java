package br.com.dolzanes.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dolzanes.model.Product;

public class CreateProduct {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.setName("Smartphone Xiaomi");
		product.setDescription("16GB 48mp");
		product.setPrice(new BigDecimal("600"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja"); 
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
	}

}
