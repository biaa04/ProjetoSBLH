package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bandas");
	
	public EntityManager getConnection() {
		return emf.createEntityManager();
		
	}

}
