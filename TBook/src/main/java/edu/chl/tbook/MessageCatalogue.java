package edu.chl.tbook;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MessageCatalogue extends AbstractDAO<TBookMessage, Long> implements IMessageCatalogue {

    private MessageCatalogue(String puName) {
        super(TBookMessage.class, puName);
    } 
    
    public static IMessageCatalogue newInstance(String puName){
        return new MessageCatalogue(puName);
    }

    @Override
    public List<TBookMessage> getByReciever(TBookUser reciever) {
        EntityManager em = null;
        List<TBookMessage> messages = null;
        try {
            em = getEntityManager();
            String query = "select m from TBookMessage m WHERE m.toUser.userName = '"+reciever.getUserName()+"'";
            TypedQuery<TBookMessage> q = em.createQuery(query, TBookMessage.class);
            messages = q.getResultList();
        } catch (Exception ex) {
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return messages;
    }

    @Override
    public List<TBookMessage> getBySender(TBookUser sender) {
        EntityManager em = null;
        List<TBookMessage> messages = null;
        try {
            em = getEntityManager();
            String query = "select m from TBookMessage m WHERE m.fromUser.userName = '"+sender.getUserName()+"'";
            TypedQuery<TBookMessage> q = em.createQuery(query, TBookMessage.class);
            messages = q.getResultList();
        } catch (Exception ex) {
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return messages;
    }
}
