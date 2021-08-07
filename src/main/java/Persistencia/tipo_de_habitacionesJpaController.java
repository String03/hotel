/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.tipo_de_habitaciones;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author fvg
 */
public class tipo_de_habitacionesJpaController implements Serializable {

    public tipo_de_habitacionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public tipo_de_habitacionesJpaController() {
    }

    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(tipo_de_habitaciones tipo_de_habitaciones) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipo_de_habitaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtipo_de_habitaciones(tipo_de_habitaciones.getId()) != null) {
                throw new PreexistingEntityException("tipo_de_habitaciones " + tipo_de_habitaciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tipo_de_habitaciones tipo_de_habitaciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipo_de_habitaciones = em.merge(tipo_de_habitaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipo_de_habitaciones.getId();
                if (findtipo_de_habitaciones(id) == null) {
                    throw new NonexistentEntityException("The tipo_de_habitaciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipo_de_habitaciones tipo_de_habitaciones;
            try {
                tipo_de_habitaciones = em.getReference(tipo_de_habitaciones.class, id);
                tipo_de_habitaciones.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo_de_habitaciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipo_de_habitaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tipo_de_habitaciones> findtipo_de_habitacionesEntities() {
        return findtipo_de_habitacionesEntities(true, -1, -1);
    }

    public List<tipo_de_habitaciones> findtipo_de_habitacionesEntities(int maxResults, int firstResult) {
        return findtipo_de_habitacionesEntities(false, maxResults, firstResult);
    }

    private List<tipo_de_habitaciones> findtipo_de_habitacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tipo_de_habitaciones.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public tipo_de_habitaciones findtipo_de_habitaciones(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tipo_de_habitaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int gettipo_de_habitacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tipo_de_habitaciones> rt = cq.from(tipo_de_habitaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
