package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Banda;


public class DAO {
	
	private static DAO instance;
    protected EntityManager entityManager;

    public static DAO getInstance(){
      if (instance == null){
         instance = new DAO();
      }

      return instance;
    }
//
    public DAO() {
      entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
     EntityManagerFactory factory =
     Persistence.createEntityManagerFactory("SBLH");
     if (entityManager == null) {
       entityManager = factory.createEntityManager();
     }

     return entityManager;
    }

    public Banda getById(final int idbanda) {
      return entityManager.find(Banda.class, idbanda);
    }

    @SuppressWarnings("unchecked")
    public List<Banda> findAll() {
      return entityManager.createQuery("FROM " +
      Banda.class.getName()).getResultList();
    }

    public void NewBanda(Banda banda) {
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(banda);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void EditarBanda(Banda banda) {
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(banda);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void RemoveBanda(Banda banda) {
      try {
         entityManager.getTransaction().begin();
         banda = entityManager.find(Banda.class, banda.getIdbanda());
         entityManager.remove(banda);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void removeById(final int idbanda) {
      try {
         Banda banda = getById(idbanda);
         RemoveBanda(banda);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }

	
}
