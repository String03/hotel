/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import com.Trabajo_Practico_Integrador.hotel.entities.Habitaciones;
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

    public void create(Habitaciones habitaciones) throws PreexistingEntityException, Exception {
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

    public void edit(Habitaciones habitaciones) throws NonexistentEntityException, Exception {
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
            Habitaciones habitaciones;
            try {
                habitaciones = em.getReference(Habitaciones.class, id);
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

    public List<Habitaciones> findhabitacionesEntities() {
        return findhabitacionesEntities(true, -1, -1);
    }

    public List<Habitaciones> findhabitacionesEntities(int maxResults, int firstResult) {
        return findhabitacionesEntities(false, maxResults, firstResult);
    }

    private List<Habitaciones> findhabitacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Habitaciones.class));
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

    public Habitaciones findhabitaciones(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Habitaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int gethabitacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Habitaciones> rt = cq.from(Habitaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
