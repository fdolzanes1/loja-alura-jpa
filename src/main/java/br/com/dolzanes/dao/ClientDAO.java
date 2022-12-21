package br.com.dolzanes.dao;

import javax.persistence.EntityManager;

import br.com.dolzanes.model.Client;

public class ClientDAO {
	
	private EntityManager em;
	
	public ClientDAO(EntityManager em) {
		this.em = em;
	}
	
	public void create(Client client) {
		this.em.persist(client);
	}
	
	public Client findById(Long id) {
		return em.find(Client.class, id);
	}

}
