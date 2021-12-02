package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Banda;

public class Teste {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SBLH");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[]args) {
		Banda banda = entityManager.find(Banda.class, 1);
		System.out.println("Nome da banda: "+ banda.getNome());
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
