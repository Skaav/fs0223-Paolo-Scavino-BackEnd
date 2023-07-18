package Class;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class ArchivioBibliotecario {
    private EntityManagerFactory entityManagerFactory;

    public ArchivioBibliotecario() {
        entityManagerFactory = Persistence.createEntityManagerFactory("library");
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(elemento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void rimuoviElemento(String isbn) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            ElementoCatalogo elemento = entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.isbn = :isbn", ElementoCatalogo.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            entityManager.remove(elemento);
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Elemento con ISBN " + isbn + " non trovato.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public ElementoCatalogo ricercaPerISBN(String isbn) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.isbn = :isbn", ElementoCatalogo.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento con ISBN " + isbn + " non trovato.");
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int annoPubblicazione) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :annoPubblicazione", ElementoCatalogo.class)
                    .setParameter("annoPubblicazione", annoPubblicazione)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.autore = :autore", ElementoCatalogo.class)
                    .setParameter("autore", autore)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<ElementoCatalogo> ricercaPerTitolo(String titolo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo", ElementoCatalogo.class)
                    .setParameter("titolo", "%" + titolo + "%")
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Prestito> ricercaPrestitiUtente(String numeroTessera) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class)
                    .setParameter("numeroTessera", numeroTessera)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Prestito> ricercaPrestitiScadutiNonRestituiti() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Date now = new Date();

        try {
            return entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :now AND p.dataRestituzioneEffettiva IS NULL", Prestito.class)
                    .setParameter("now", now)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    public void aggiungiPrestito(Prestito prestito) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(prestito);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void chiudi() {
        entityManagerFactory.close();
    }
}