package br.com.dolzanes.main;

import javax.persistence.EntityManager;

import br.com.dolzanes.dao.ClientDAO;
import br.com.dolzanes.model.Client;
import br.com.dolzanes.util.JPAUtil;

public class CreateClient {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ClientDAO clientDao = new ClientDAO(entityManager);
		
		Client client = new Client("Fabiano Dolzanes", "93505698253");
		clientDao.create(client);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}
