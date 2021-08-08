/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import com.Trabajo_Practico_Integrador.hotel.entities.Huespedes;
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
public class huespedesJpaController implements Serializable {

    public huespedesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public huespedesJpaController() {
    }

    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Huespedes huespedes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(huespedes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findhuespedes(huespedes.getId()) != null) {
                throw new PreexistingEntityException("huespedes " + huespedes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Huespedes huespedes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            huespedes = em.merge(huespedes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = huespedes.getId();
                if (findhuespedes(id) == null) {
                    throw new NonexistentEntityException("The huespedes with id " + id + " no longer exists.");
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
            Huespedes huespedes;
            try {
                huespedes = em.getReference(Huespedes.class, id);
                huespedes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The huespedes with id " + id + " no longer exists.", enfe);
            }
            em.remove(huespedes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Huespedes> findhuespedesEntities() {
        return findhuespedesEntities(true, -1, -1);
    }

    public List<Huespedes> findhuespedesEntities(int maxResults, int firstResult) {
        return findhuespedesEntities(false, maxResults, firstResult);
    }

    private List<Huespedes> findhuespedesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Huespedes.class));
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

    public Huespedes findhuespedes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Huespedes.class, id);
        } finally {
            em.close();
        }
    }

    public int gethuespedesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Huespedes> rt = cq.from(Huespedes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
