package br.com.dolzanes.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.CategoryDAO;
import br.com.dolzanes.dao.ClientDAO;
import br.com.dolzanes.dao.OrderDAO;
import br.com.dolzanes.dao.ProductDAO;
import br.com.dolzanes.model.Category;
import br.com.dolzanes.model.Client;
import br.com.dolzanes.model.ItemOrder;
import br.com.dolzanes.model.Order;
import br.com.dolzanes.model.Product;
import br.com.dolzanes.util.JPAUtil;

public class CreateOrder {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProductDAO productDao = new ProductDAO(entityManager);
		ClientDAO clientDao = new ClientDAO(entityManager);
		OrderDAO orderDao = new OrderDAO(entityManager);
		
		Product product1 = productDao.findById(3l);
		Product product2 = productDao.findById(1l);
		
		Client client = clientDao.findById(1l);
		
		Order order = new Order(client);
		ItemOrder itemOrder1 = new ItemOrder(10, order, product1);
		ItemOrder itemOrder2 = new ItemOrder(5, order, product2);
		
		order.addItem(itemOrder1);
		order.addItem(itemOrder2);
		
		Double SumItem1 = itemOrder1.getAmount() * itemOrder1.getPriceUnit();
		Double SumItem2 = itemOrder2.getAmount() * itemOrder2.getPriceUnit();
		
		
		List<Double> sumItens = new ArrayList<>();
		
		sumItens.add(SumItem1);
		sumItens.add(SumItem2);
		
		Double sum = 0.0;

        for (Double number : sumItens){
            sum += number;
        }
		
		order.setSumValue(sum);
		
		orderDao.create(order);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();
				
	}
		
}
