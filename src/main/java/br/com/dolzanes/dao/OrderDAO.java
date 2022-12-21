package br.com.dolzanes.dao;

import javax.persistence.EntityManager;

import br.com.dolzanes.model.Order;

public class OrderDAO {
	
	private EntityManager em;

	public OrderDAO(EntityManager em) {
		this.em = em;
	}

	public void create(Order order) {
		this.em.persist(order);
	}

}
