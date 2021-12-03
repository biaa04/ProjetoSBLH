package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class daoBanda {
	public EntityManager getEM() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
		return factory.createEntityManager();
	}	
		

	
	/*//EntityManagerFactory emf;
	//EntityManager em;
	
	public ControllerBanda() {
		//emf = Persistence.createEntityManagerFactory("PU");
		//em = emf.createEntityManager();
	}*/
	public Banda salvar(Banda banda) throws Exception {
		EntityManager em = getEM();
	try {
		 em.getTransaction().begin();
		 em.persist(banda);
		 em.getTransaction().commit();
		}catch(Exception e ) {
	     em.getTransaction().rollback();  
		} finally {
	        em.close();
	    }
		
		return banda;
		
	}	
	
	
	public Banda editar(Banda banda) throws Exception {
		EntityManager em = getEM();
	try {
		 em.getTransaction().begin();
		 em.merge(banda);
		 em.getTransaction().commit();
		}catch(Exception e ) {
	     em.getTransaction().rollback();  
		} finally {
	        em.close();
	    }
		
		return banda;
		
	}
	
	public void remove(Long idbanda) {
		EntityManager em =getEM();
		
		Banda br= em.find(Banda.class, idbanda);
		try {
			em.getTransaction().begin();
			em.remove(br);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}

	
	public Banda pesquisarPorId(Long idbanda) {
		EntityManager em = getEM();
		Banda bp = null;
		try {
			
			bp = em.find(Banda.class, idbanda);
		} finally {
			em.close();
		}
		return bp;
		
	}
	
	public ArrayList<Banda> findAll(){
		EntityManager em = getEM();
		List<Banda> bandalista = null;		
try {
	bandalista = em.createQuery("from Banda").getResultList();
			
		} catch (Exception e) {
			 System.out.println(e);
		} finally {
			em.close();
		}
		return (ArrayList<Banda>) bandalista;
	}
	
	
	
	
	
	
	
//	public void remover(Banda banda) {
//		em.getTransaction().begin();
//		Query q = em.createNamedQuery("delete banda from banda where idbanda ="+banda.getNome());
//		em.getTransaction().commit();
//		emf.close();
//	}
	
}

