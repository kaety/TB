package edu.chl.tbook;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Base class any persisting collection
 * 
 * NOTE: This is ** Application Managed Persistence ** and RESOURCE_LOCAL transactions
 * because we will run JUnit test's i.e.  **** Java SE  ****
 * 
 * @author hajo
 */

public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    private final EntityManagerFactory emf;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }
 
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }

    @Override
    public void add(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Using out parameter
     */
    @Override
    public void update(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T find(K id) {
        EntityManager em = getEntityManager();
        T t = em.find(clazz, id);
        return t;
    }

    @Override
    public List<T> getAll() {
        return get(true, -1, -1);
    }

    @Override
    public List<T> getRange(int maxResults, int firstResult) {
        return get(false, maxResults, firstResult);
    }

    @Override
    public int getCount() {
        EntityManager em = getEntityManager();
        int count = -1;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            em.close();
        }
        return count;
    }

    // This uses the criteria API see queries...
    private List<T> get(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        List<T> found = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            found.addAll(q.getResultList());
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            em.close();
        }
        return found;
    }
}