package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Biglietto;
import com.epicode.model.Utente;

public class UtenteDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(UtenteDAO.class);
	
	
	public static void salvaUtente(Utente u) {
		try  {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		log.info("Utente salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaUtente(Utente u) {
		try  {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		log.info("Utente rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Utente getUtenteById(Long numeroTessera) {
		try {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, numeroTessera);
		em.getTransaction().commit();
		return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}

}
