/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.empleados;
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
public class empleadosJpaController implements Serializable {

    public empleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public empleadosJpaController() {
        
    }

    
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(empleados empleados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findempleados(empleados.getId()) != null) {
                throw new PreexistingEntityException("empleados " + empleados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleados = em.merge(empleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleados.getId();
                if (findempleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            empleados empleados;
            try {
                empleados = em.getReference(empleados.class, id);
                empleados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<empleados> findempleadosEntities() {
        return findempleadosEntities(true, -1, -1);
    }

    public List<empleados> findempleadosEntities(int maxResults, int firstResult) {
        return findempleadosEntities(false, maxResults, firstResult);
    }

    private List<empleados> findempleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(empleados.class));
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

    public empleados findempleados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getempleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<empleados> rt = cq.from(empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
