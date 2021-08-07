/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.habitaciones;
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
public class habitacionesJpaController implements Serializable {

    public habitacionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public habitacionesJpaController() {
    }

    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(habitaciones habitaciones) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(habitaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findhabitaciones(habitaciones.getId()) != null) {
                throw new PreexistingEntityException("habitaciones " + habitaciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(habitaciones habitaciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            habitaciones = em.merge(habitaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = habitaciones.getId();
                if (findhabitaciones(id) == null) {
                    throw new NonexistentEntityException("The habitaciones with id " + id + " no longer exists.");
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
            habitaciones habitaciones;
            try {
                habitaciones = em.getReference(habitaciones.class, id);
                habitaciones.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitaciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(habitaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<habitaciones> findhabitacionesEntities() {
        return findhabitacionesEntities(true, -1, -1);
    }

    public List<habitaciones> findhabitacionesEntities(int maxResults, int firstResult) {
        return findhabitacionesEntities(false, maxResults, firstResult);
    }

    private List<habitaciones> findhabitacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(habitaciones.class));
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

    public habitaciones findhabitaciones(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(habitaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int gethabitacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<habitaciones> rt = cq.from(habitaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
